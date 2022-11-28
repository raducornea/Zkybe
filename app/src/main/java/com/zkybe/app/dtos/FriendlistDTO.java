package com.zkybe.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private List<Integer> friends;

    public FriendlistDTO(User user) {
        this.userId = user.getId();
        this.friends = user.getFriendlist().stream().map(User::getId).collect(Collectors.toList());

    }
}
