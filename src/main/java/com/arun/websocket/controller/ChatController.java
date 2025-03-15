package com.arun.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // Method to handle messages from clients
    @MessageMapping("/sendMessage")  // Maps messages from clients to this method
    @SendTo("/topic/messages")      // Sends the message to all subscribed clients
    public String sendMessage(String message) {
        return message;  // Simply returns the message to be broadcasted
    }
}
