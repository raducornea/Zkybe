package com.zkybe.app.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zkybe.app.dtos.FriendlistDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "friendlists")
@IdClass(FriendlistId.class)
public class FriendList implements Serializable {

    @Id
    private Integer userId;

    @Id
    private Integer friendId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "friend_id", insertable = false, updatable = false)
    private User friend;

    public FriendList(FriendlistDTO friendlistDTO)
    {
        this.userId = friendlistDTO.getUserId();
        this.friendId = friendlistDTO.getFriendId();
    }



}
