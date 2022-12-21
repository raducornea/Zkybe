package com.zkybe.app.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class BlockedUserId implements Serializable {
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "blocked_user_id")
    private Integer blockedUserId;

    public BlockedUserId(Integer idUser, Integer idBlockedUser) {
        this.userId = idUser;
        this.blockedUserId = idBlockedUser;
    }
}
