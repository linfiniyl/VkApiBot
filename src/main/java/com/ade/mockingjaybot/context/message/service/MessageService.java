package com.ade.mockingjaybot.context.message.service;

import com.ade.mockingjaybot.api.VkBotApi;
import com.ade.mockingjaybot.context.message.pojo.MessageType;
import com.ade.mockingjaybot.context.message.pojo.request.VkEventRequest;
import com.ade.mockingjaybot.context.message.pojo.response.VkMessageResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MessageService {
    @Value("${vk.api.confirmation_key}")
    private String confirmationKey;
    @Value("${vk.access-token}")
    private String accessToken;
    @Value("${vk.group_id}")
    private long groupId;
    private final VkBotApi vkBotApi;
    private final ObjectMapper objectMapper;

    public HttpEntity<?> handleCallback(String json) throws IOException {
        MessageType type = objectMapper.readValue(json, MessageType.class);
        Random random = new Random();
            switch (type.getType()) {
                case "message_new" -> {
                    VkEventRequest request = objectMapper.readValue(json, VkEventRequest.class);

                    VkMessageResponse response = VkMessageResponse
                            .builder()
                            .userId(request.getObject().getMessage().getFromId())
                            .peerId(request.getObject().getMessage().getPeerId())
                            .message("Вы сказали: " + request.getObject().getMessage().getText())
                            .randomId(random.nextInt())
                            .build();
                    return vkBotApi.sendMessage(response);
                }

                case "confirmation" -> {
                    if (groupId == type.getGroupId()) {
                        return ResponseEntity.status(HttpStatus.OK).body(confirmationKey);
                    } else {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{}");
                    }
                }
                default -> {

                    return ResponseEntity.status(HttpStatus.OK).body("ok");
                }
            }
    }
}
