package com.hewei.websocket.controller;

import com.hewei.websocket.conts.Constants;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author hewei
 * @date 2020/9/18
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/send")
    public void send(String channel, String message) {
        // 消息入库

        // 即时通知
        String text = "[" + LocalDateTime.now().toString() + "]: " + message;
        simpMessagingTemplate.convertAndSend(Constants.DESTINATION_TOPIC + "/" + channel, text);
    }
}
