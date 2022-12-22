package com.zkybe.app.models;

import com.zkybe.app.dtos.FriendRequestDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "friend_requests")
@IdClass(FriendRequestId.class)
public class FriendRequest implements Serializable {
    @Id
    private Integer senderId;

    @Id
    private Integer receiverId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    //@MapsId
    @JoinColumn(name = "sender_id", insertable = false, updatable = false)
    private User sender;


    @ManyToOne(fetch = FetchType.LAZY)
    //@Id
    @JoinColumn(name = "receiver_id", insertable = false, updatable = false)
    private User receiver;

    @Column(name = "answered", nullable = false)
    private Boolean answered;

    public FriendRequest(FriendRequestDTO friendRequestDTO) {
        this.senderId = friendRequestDTO.getSenderId();
        this.receiverId = friendRequestDTO.getReceiverId();
        this.answered = friendRequestDTO.getAnswered();
    }

    public FriendRequest(Integer senderId, Integer receiverId, boolean b) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.answered = b;
    }
}
