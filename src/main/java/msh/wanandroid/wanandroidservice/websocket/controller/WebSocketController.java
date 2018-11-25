package msh.wanandroid.wanandroidservice.websocket.controller;

import msh.wanandroid.wanandroidservice.message.LocalLogger;
import msh.wanandroid.wanandroidservice.message.ToUserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * Created by lincoln on 16-10-25
 */
@Controller
public class WebSocketController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public LocalLogger say(LocalLogger logger) {
        System.out.println("clientMessage.getName() = " + logger.toString());
        return logger;
    }

    //发送信息 使用 也可以 直接return
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/cheat")
    public void cheatTo(ToUserMessage toUserMessage) {
        System.out.println("toUserMessage.getMessage() = " + toUserMessage.getMessage());
        System.out.println("toUserMessage.getUserId() = " + toUserMessage.getUserId());
        messagingTemplate.convertAndSendToUser(toUserMessage.getUserId(), "/message", toUserMessage.getMessage());
    }
}
