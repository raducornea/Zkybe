package com.zkybe.app.presentation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private static final Map<String, List<WebSocketSession>> sessions = new HashMap<>();

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //        registry.addHandler(new EchoWebSocketHandler(), "/ws").setAllowedOrigins("*");
        registry.addHandler(new EchoWebSocketHandler(), "/ws/{roomId}").setAllowedOrigins("*");
    }

    public static class EchoWebSocketHandler extends TextWebSocketHandler {

        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            String roomId = (String) session.getAttributes().get("roomId");
            List<WebSocketSession> roomSessions = sessions.get(roomId);
            if (roomSessions == null) {
                roomSessions = new ArrayList<>();
                sessions.put(roomId, roomSessions);
            }

            // validare daca in tabela de prieteni user-ul roomId trebuie sa fie prieten cu user-ul care vrea sa trimita mesaje
            roomSessions.add(session);
        }

        @Override
        protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
            String roomId = (String) session.getAttributes().get("roomId");
            List<WebSocketSession> roomSessions = sessions.get(roomId);
            for (WebSocketSession webSocketSession : roomSessions) {
                webSocketSession.sendMessage(message);
            }
        }

        @Override
        public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
            String roomId = (String) session.getAttributes().get("roomId");
            List<WebSocketSession> roomSessions = sessions.get(roomId);
            roomSessions.remove(session);
        }
    }
}
