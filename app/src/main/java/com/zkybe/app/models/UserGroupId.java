package com.zkybe.app.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UserGroupId implements Serializable {
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "ig_group")
    private Integer idGroup;

    private UserGroupId() {
    }

    public UserGroupId(Integer idUser, Integer idGroup) {
        this.idUser = idUser;
        this.idGroup = idGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGroupId that = (UserGroupId) o;
        return Objects.equals(idUser, that.idUser) && Objects.equals(idGroup, that.idGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idGroup);
    }

}
