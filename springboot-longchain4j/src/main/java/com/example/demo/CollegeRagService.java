package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.retriever.EmbeddingStoreRetriever;
import dev.langchain4j.retriever.Retriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;

@Service
public class CollegeRagService {

    private final DepartmentRepository repo;
    private final EmbeddingModel embeddingModel;
    private final ChatLanguageModel chatModel;

    private Retriever retriever;
    private boolean isDataLoaded = false;

    @Autowired
    public CollegeRagService(DepartmentRepository repo,
                             ChatLanguageModel chatModel,
                             EmbeddingModel embeddingModel) {
        this.repo = repo;
        this.chatModel = chatModel;
        this.embeddingModel = embeddingModel;
        System.out.println("✅ CollegeRagService initialized");
    }

    // Lazy loading to avoid DB timing issues
    private synchronized void loadDataOnce() {
        if (isDataLoaded) return;

        System.out.println("🔁 Loading department data from DB and generating embeddings...");

        EmbeddingStore<TextSegment> store = new InMemoryEmbeddingStore<>();
        List<Department> departments = repo.findAll();

        if (departments.isEmpty()) {
            System.out.println("⚠️ No department data found in the database.");
        } else {
            for (Department d : departments) {
                String text = String.format("Department: %s. HOD: %s. Info: %s",
                        d.getName(), d.getHod(), d.getDescription());

                System.out.println("📌 Embedding department: " + text);

                store.add(
                        embeddingModel.embed(text).content(),
                        TextSegment.from(text)
                );
            }

            this.retriever = EmbeddingStoreRetriever.from(store, embeddingModel);
            this.isDataLoaded = true;
            System.out.println("✅ All departments embedded successfully.");
        }
    }

    public String chat(String prompt) {
        loadDataOnce();

        if (retriever == null) {
            return "⚠️ No department data available for answering.";
        }

        System.out.println("\n💬 Prompt received: " + prompt);

        List<TextSegment> contextSegments = retriever.findRelevant(prompt);

        if (contextSegments.isEmpty()) {
            System.out.println("❌ No relevant department found.");
            return "No relevant department found for your question.";
        }

        String context = contextSegments.stream()
                .map(TextSegment::text)
                .collect(Collectors.joining("\n"));

        String fullPrompt = String.format("""
                Answer the question based on the context below.
                Context:
                %s

                Question: %s
                """, context, prompt);

        System.out.println("📤 Sending prompt to LLM:\n" + fullPrompt);

        String response = chatModel.generate(fullPrompt).toString();

        System.out.println("✅ Response from LLM:\n" + response);

        return response;
    }
}
