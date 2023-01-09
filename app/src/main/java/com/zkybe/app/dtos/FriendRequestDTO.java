package com.zkybe.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkybe.app.models.FriendRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FriendRequestDTO {
    @JsonProperty("sender_id")
    private Integer senderId;

    @JsonProperty("receiver_id")
    private Integer receiverId;

    @JsonProperty("answered")
    private Boolean answered;

    public FriendRequestDTO(FriendRequest friendRequest) {
        this.senderId = friendRequest.getSenderId();
        this.receiverId = friendRequest.getReceiverId();
        this.answered = friendRequest.getAnswered();
    }

    public FriendRequestDTO(Integer senderId, Integer receiverId, boolean b) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.answered = b;
    }
}
