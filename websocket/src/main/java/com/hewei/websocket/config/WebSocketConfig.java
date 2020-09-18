package com.hewei.websocket.config;

import com.hewei.websocket.conts.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author hewei
 * @date 2020/9/17
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // /portfolio is the HTTP URL for the endpoint to which a WebSocket (or SockJS) client needs to connect for the WebSocket handshake.
        registry.addEndpoint(Constants.SOCK_JS_ENDPOINT).withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // STOMP messages whose destination header begins with /app are routed to @MessageMapping methods in @Controller classes.
        config.setApplicationDestinationPrefixes(Constants.DESTINATION_PREFIXES);
        // Use the built-in message broker for subscriptions and broadcasting and route messages whose destination header begins with /topic `or `/queue to the broker.
        config.enableSimpleBroker(Constants.DESTINATION_TOPIC, Constants.DESTINATION_QUEUE);
    }
}
