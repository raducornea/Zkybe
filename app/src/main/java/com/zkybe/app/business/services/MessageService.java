package com.zkybe.app.business.services;

import com.zkybe.app.dtos.MessageDTO;
import com.zkybe.app.persistence.mappers.MessageMapper;
import com.zkybe.app.persistence.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageMapper messageMapper;

    public List<MessageDTO> getMessages() {
        return messageRepository.findAll().stream()
                .map(message -> messageMapper.mapToDto(message))
                .collect(Collectors.toList());
    }

    public MessageDTO addMessage(MessageDTO messageDTO) {
        return messageMapper.mapToDto(messageRepository
                .save(messageMapper.mapToModel(messageDTO)));
    }
}
