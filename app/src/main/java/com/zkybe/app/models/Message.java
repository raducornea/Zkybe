package com.zkybe.app.models;

import com.zkybe.app.dtos.MessageDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_sender")
    private Integer idSender;

    @Column(name = "id_receiver")
    private Integer idReceiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sender", nullable = false, insertable = false, updatable = false)
    private User sender;


    @ManyToOne
    @JoinColumn(name = "id_receiver", nullable = false, insertable = false, updatable = false)
    private Group received;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    public Message(MessageDTO messageDTO) {
        this.id = messageDTO.getId();
        this.date = messageDTO.getDate();
        this.time = messageDTO.getTime();
        this.content = messageDTO.getContent();
        this.idSender = messageDTO.getIdSender();
        this.idReceiver = messageDTO.getIdReceivers();
    }

}
