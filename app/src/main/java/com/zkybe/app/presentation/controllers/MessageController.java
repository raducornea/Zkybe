package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.MessageService;
import com.zkybe.app.dtos.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("messages")
    public List<MessageDTO> getAllMessages() {
        return messageService.getMessages();
    }
}
