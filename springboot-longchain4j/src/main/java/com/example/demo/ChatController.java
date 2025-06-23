package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final CollegeRagService ragService;

    @Autowired
    public ChatController(CollegeRagService ragService) {
        this.ragService = ragService;
    }

   
    @PostMapping
    public String chat(@RequestBody ChatRequest request) {
        return ragService.chat(request.getPrompt());
    }
}
