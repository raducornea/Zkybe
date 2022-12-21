package com.zkybe.app.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "groups_users")
public class UserGroup {
    @EmbeddedId
    private UserGroupId id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUser")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idGroup")
    private Group group;

    @Column(name = "role")
    private String role;

    public UserGroup(User user, Group group) {
        this.user = user;
        this.group = group;
        this.id = new UserGroupId(user.getId(), group.getId());
        this.role = role;
    }

    public UserGroup(Optional<User> user, Optional<Group> group, String role) {
        if (user.isPresent() && group.isPresent()) {
            user.ifPresent(value -> this.user = value);
            group.ifPresent(value -> this.group = value);
            this.id = new UserGroupId(user.get().getId(), group.get().getId());
        }
        this.role = role;
    }

}
