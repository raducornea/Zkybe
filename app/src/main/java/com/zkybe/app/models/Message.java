package com.zkybe.app.models;

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

    @ManyToOne
    @JoinColumn(name = "id_sender", nullable = false)
    private User sender;


    @ManyToOne
    @JoinColumn(name = "id_receiver", nullable = false, insertable = false, updatable = false)
    private Message received;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

}
