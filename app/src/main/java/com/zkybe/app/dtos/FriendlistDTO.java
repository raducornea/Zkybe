package com.zkybe.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkybe.app.models.FriendList;
import com.zkybe.app.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class FriendlistDTO {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("friend_id")
    private Integer friendId;

    public FriendlistDTO(FriendList friendList) {
        this.userId = friendList.getUserId();
        this.friendId = friendList.getFriendId();

    }

    public FriendlistDTO(Integer userId, Integer friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }
}
