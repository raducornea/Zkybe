package com.zkybe.app.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "groups_users")
public class UserGroup {
    @EmbeddedId
    private UserGroupId id;

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
    }

}
