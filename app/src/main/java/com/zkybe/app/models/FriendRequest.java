package com.zkybe.app.models;

import com.zkybe.app.dtos.FriendRequestDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "friend_requests")
public class FriendRequest {
    @Id
    @Column(name = "sender_id")
    private Integer id;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;

    @Column(name = "answered", nullable = false)
    private Boolean answered;
}
