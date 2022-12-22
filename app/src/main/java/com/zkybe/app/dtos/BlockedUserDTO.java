package com.zkybe.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkybe.app.models.BlockedUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlockedUserDTO {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("blocked_user_id")
    private Integer blockedUserId;

    public BlockedUserDTO(BlockedUser blockedUser) {
        this.userId = blockedUser.getUser().getId();
        this.blockedUserId = blockedUser.getBlockedUser().getId();
    }
}
