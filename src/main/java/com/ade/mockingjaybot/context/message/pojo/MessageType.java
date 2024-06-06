package com.ade.mockingjaybot.context.message.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageType {
    @JsonProperty("group_id")
    private int groupId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("event_id")
    private String eventId;
    @JsonProperty("v")
    private String v;
}
