package com.example.demo;

public class ChatRequest {

    private String prompt;

    // Required for Jackson
    public ChatRequest() {}

    public ChatRequest(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
