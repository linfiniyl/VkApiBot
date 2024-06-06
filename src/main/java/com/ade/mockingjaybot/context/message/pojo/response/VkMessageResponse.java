package com.ade.mockingjaybot.context.message.pojo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@Builder
public class VkMessageResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("v")
    private String v;
    @NonNull
    @JsonProperty("user_id")
    private long userId;
    @NonNull
    @JsonProperty("random_id")
    private long randomId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("peer_id")
    private long peerId;
    private long chatId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("message")
    private String message;

}
