package com.App.IA.Controller;

import com.App.IA.Services.Interfaces.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class IAController {

    private final AIService IAService;

    @PostMapping("/chat")
    public ResponseEntity<Map<String, String>> ask(
            @RequestBody Map<String, String> body) {

        String mensaje = body.get("message");
        String chatId = body.getOrDefault("chatId", "default");

        String respuesta = IAService.preguntar(mensaje, chatId);

        return ResponseEntity.ok(Map.of("response", respuesta));
    }

}