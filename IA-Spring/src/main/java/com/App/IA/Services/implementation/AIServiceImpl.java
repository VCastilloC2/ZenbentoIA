package com.App.IA.Services.implementation;

import com.App.IA.Services.Interfaces.AIService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIServiceImpl implements AIService {

    private final ChatClient chatClient;

    public AIServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();;
    }

    @Override
    public String preguntar(String prompt) {

        System.out.println("Enviando prompt a Ollama: " + prompt);

        String response = chatClient
                .prompt()
                .user(prompt)
                .call()
                .content();

        System.out.println("Respuesta IA: " + response);

        return response;
    }

}