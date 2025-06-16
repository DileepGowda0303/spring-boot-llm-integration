package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OllamaService;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Autowired
    private OllamaService ollamaService;

    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {
        return ollamaService.chatWithOllama(prompt);
    }
}