package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.AllMiniLmL6V2EmbeddingModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
@Configuration
public class OllamaConfig {

	 @Bean
	    public ChatLanguageModel ollamaChatModel() {
			return OllamaChatModel.builder()
	                .baseUrl("http://localhost:11434")
	                .modelName("llama2")
	                .build();
	    }

	    @Bean
	    public EmbeddingModel embeddingModel() {
	        return new AllMiniLmL6V2EmbeddingModel();
	    }
}
