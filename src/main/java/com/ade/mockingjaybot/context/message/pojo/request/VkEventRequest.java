package com.ade.mockingjaybot.context.message.pojo.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VkEventRequest {
    @JsonProperty("group_id")
    private int groupId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("event_id")
    private String eventId;
    @JsonProperty("v")
    private String v;
    @JsonProperty("object")
    private VkMessageEvent object;

    @Data
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public static class VkMessageEvent {

        @JsonProperty("message")
        private VkMessage message;

        @JsonProperty("client_info")
        private VkClientInfo clientInfo;

        @Data
        public static class VkMessage {
            @JsonProperty("date")
            private long date;
            @JsonProperty("from_id")
            private long fromId;
            @JsonProperty("id")
            private long id;
            @JsonProperty("out")
            private long out;
            @JsonProperty("version")
            private long version;
            @JsonProperty("attachments")
            private VkAttachment[] attachments;
            @JsonProperty("conversation_message_id")
            private long conversationMessageId;
            @JsonProperty("fwd_messages")
            private VkForwardedMessage[] fwdMessages;
            @JsonProperty("important")
            private boolean important;
            @JsonProperty("is_hidden")
            private boolean isHidden;
            @JsonProperty("peer_id")
            private int peerId;
            @JsonProperty("random_id")
            private int randomId;
            @JsonProperty("text")
            private String text;

            @Data
            public static class VkForwardedMessage {
                @JsonProperty("date")
                private long date;
                @JsonProperty("from_id")
                private long fromId;
                @JsonProperty("id")
                private long id;
                @JsonProperty("is_hidden")
                private boolean isHidden;
            }

            @Data
            public static class VkAttachment {
                @JsonProperty("type")
                private String type;
                @JsonProperty("id")
                private long id;
                @JsonProperty("owner_id")
                private long ownerId;
            }
        }
        @Data
        public static class VkClientInfo {
            @JsonProperty("button_actions")
            private String[] buttonActions;
            @JsonProperty("keyboard")
            private boolean keyboard;
            @JsonProperty("inline_keyboard")
            private boolean inlineKeyboard;
            @JsonProperty("carousel")
            private boolean carousel;
            @JsonProperty("lang_id")
            private long langId;
        }

    }
}