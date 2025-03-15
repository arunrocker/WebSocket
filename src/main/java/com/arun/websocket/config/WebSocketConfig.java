package com.arun.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurationSupport;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
		//withStock() denotes if client doesn't have web socket it performs long polling
	}
	
	 @Override
	    public void configureMessageBroker(MessageBrokerRegistry registry) {
	        // Configure the message broker for handling messages
	        registry.setApplicationDestinationPrefixes("/app");  // Client-to-server messages
	        registry.enableSimpleBroker("/topic");               // Server-to-client messages
	    }

}
