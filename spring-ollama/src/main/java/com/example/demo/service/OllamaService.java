package com.example.demo.service;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OllamaService {

	private final RestTemplate restTemplate = new RestTemplate();
	private static final String OLLAMA_URL = "http://localhost:11434/api/generate";

	public String chatWithOllama(String prompt) {
		Map<String, Object> body = Map.of("model", "phi", "prompt", prompt, "stream", false);
		System.err.println("calling PI");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

		ResponseEntity<Map> response = restTemplate.postForEntity(OLLAMA_URL, request, Map.class);
		System.err.println(response);
		return response.getBody().get("response").toString();
	}

	public String generateImageWithOllama(String prompt) {
		Map<String, Object> body = Map.of("model", "", "prompt", prompt, "stream", false);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

		ResponseEntity<Map> response = restTemplate.postForEntity(OLLAMA_URL, request, Map.class);
		return response.getBody().get("response").toString();
	}

}
