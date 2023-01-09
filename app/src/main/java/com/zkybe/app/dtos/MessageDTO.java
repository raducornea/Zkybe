package com.zkybe.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkybe.app.models.Message;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MessageDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("id_sender")
    private Integer idSender;

    @JsonProperty("id_receiver")
    private Integer idReceivers;

    @JsonProperty("content")
    private String content;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("time")
    private Time time;

    public MessageDTO(Message message) {
        this.id = message.getId();
        this.idSender = message.getIdSender();
        this.idReceivers = message.getIdReceiver();
        this.content = message.getContent();
        this.date = message.getDate();
        this.time = message.getTime();
    }
}
