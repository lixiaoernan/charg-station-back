package com.demo.service;

import com.demo.feign.DeepSeekApiFeign;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class DeepSeekService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private static final String DEEPSEEK_API_URL = "https://api.deepseek.com/chat/completions"; // 示例URL，请根据实际API修改

    @Autowired
    private DeepSeekApiFeign deepSeekApiFeign;

    @Autowired
    public DeepSeekService(RestTemplate restTemplate,ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;

    }

    public String chatCompletions(String requestBody) {
        return deepSeekApiFeign.chatCompletions(requestBody);
    }

    public String chatCompletionsRestTemplate() throws JsonProcessingException {
        // 构建请求体对象
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "deepseek-chat");

        Map<String, String> message = new HashMap<>();
        message.put("role", "system");
        message.put("content", "你是谁？");

        requestBody.put("messages", Collections.singletonList(message));
        requestBody.put("stream", false);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + "sk-33ad04c4d8ce491c9dc8d2d7b9851b5d");
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(requestBody), headers);

        // 发送POST请求并接收响应
        ResponseEntity<String> response = restTemplate.exchange(DEEPSEEK_API_URL, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }
}
