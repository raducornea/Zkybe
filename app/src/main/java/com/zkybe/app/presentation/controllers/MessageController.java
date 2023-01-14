package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.MessageService;
import com.zkybe.app.dtos.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("messages")
    public List<MessageDTO> getAllMessages() {
        return messageService.getMessages();
    }

    @PostMapping("/{id}/send_message/{idReceiver}")
    public ResponseEntity<MessageDTO> addMessage(@RequestBody MessageDTO messageDTO, @PathVariable Integer id, @PathVariable Integer idReceiver) {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        messageDTO.setDate(date);

        java.sql.Time time = new java.sql.Time(millis);
        messageDTO.setTime(time);
        messageDTO.setIdSender(id);
        messageDTO.setIdReceivers(idReceiver);
        return new ResponseEntity<>(messageService.addMessage(messageDTO), new HttpHeaders(), HttpStatus.OK);
    }
}
