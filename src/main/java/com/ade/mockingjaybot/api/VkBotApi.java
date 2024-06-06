package com.ade.mockingjaybot.api;


import com.ade.mockingjaybot.context.message.pojo.response.VkMessageResponse;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import java.io.IOException;



@Component
@RequiredArgsConstructor
public class VkBotApi {
    @Value("${vk.api.version}")
    private String VK_API_VERSION;
    @Value("${vk.access-token}")
    private String accessToken;
    private final OkHttpClient httpClient;

    public HttpEntity<?> sendMessage(VkMessageResponse messageResponse) throws IOException {

        RequestBody requestBody = new FormBody
                .Builder()
                .add("peer_id", String.valueOf(messageResponse.getPeerId()))
                .add("message", messageResponse.getMessage())
                .add("random_id", String.valueOf(messageResponse.getRandomId()))
                .add("v", VK_API_VERSION)
                .add("access_token", accessToken)
                .build();

        Request request = new Request.Builder()
                .url("https://api.vk.com/method/messages.send")
                .post(requestBody)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();

        Response response = httpClient.newCall(request).execute();

        if (response.isSuccessful()) {

            return ResponseEntity.status(HttpStatus.OK).body("ok");
        } else {
            throw new IOException("Failed to send message. Status code: " + response.code());
            }
        }
    }

