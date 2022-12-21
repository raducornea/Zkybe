package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.MessageDTO;
import com.zkybe.app.models.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {
    public MessageDTO mapToDto(Message message) {
        return new MessageDTO(message);
    }

    public Message mapToModel(MessageDTO messageDTO) {
        return new Message(messageDTO);
    }
}
