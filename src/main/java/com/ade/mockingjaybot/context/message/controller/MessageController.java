package com.ade.mockingjaybot.context.message.controller;

import com.ade.mockingjaybot.context.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private final AsyncTaskExecutor asyncTaskExecutor;

    @PostMapping
    public HttpEntity<?> handleCallback(@RequestBody String json) throws IOException {

        return messageService.handleCallback(json);

    }
}
