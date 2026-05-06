package com.App.IA.Services.implementation;

import com.App.IA.Services.Interfaces.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIServiceImpl implements AIService {

    private final ChatClient chatClient;

    @Value("${app.ai.negacion-respuesta}")
    private String mensajeNegacion;

    @Override
    public String preguntar(String mensaje, String chatId) {
        try {
            String respuesta = chatClient
                    .prompt()
                    .user(
                            mensaje.strip() // Quita multiples espacios en el inicio y en el fin
                                    .replaceAll("\\s+", " ") // Reduce múltiples espacios a uno
                    )
                    .advisors()
                    .call()
                    .content();

            if (respuesta == null || respuesta.isBlank()) {
                return mensajeNegacion;
            }

            return respuesta;

        } catch (Exception e) {
            return "Error al conectar con la IA. Intenta nuevamente.";
        }
    }

}