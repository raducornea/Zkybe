package com.zkybe.app.models;

import com.zkybe.app.dtos.BlockedUserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "blocked_users")
@IdClass(BlockedUserId.class)
public class BlockedUser implements Serializable {
//    @Id
//    @Column(name = "user_id")
//    private Integer userId;
//    @EmbeddedId
//    private BlockedUserId id;

    @Id
    private Integer userId;

    @Id
    private Integer blockedUserId;

    @ManyToOne
   // @Id
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User user;

    @ManyToOne
   // @Id
    @JoinColumn(name = "blocked_user_id", nullable = false, insertable = false, updatable = false)
    private User blockedUser;


    public BlockedUser(Optional<User> uuser, Optional<User> blockedUser)
    {
        if(uuser.isPresent() && blockedUser.isPresent()) {
            this.user = uuser.get();
            this.userId = uuser.get().getId();
            this.blockedUserId = blockedUser.get().getId();
            this.blockedUser = blockedUser.get();
            //this.id = new BlockedUserId(uuser.get().getId(), blockedUser.get().getId());
        }
    }
    public BlockedUser(Integer userId, Integer blockedUserId) {
        this.userId = userId;
        this.blockedUserId = blockedUserId;
    }


}
