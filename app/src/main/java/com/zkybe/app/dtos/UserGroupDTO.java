package com.zkybe.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkybe.app.models.UserGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserGroupDTO {
    @JsonProperty("idUser")
    private Integer idUser;

    @JsonProperty("idGroup")
    private Integer idGroup;

    @JsonProperty("role")
    private String role;

    public UserGroupDTO(UserGroup userGroup) {
        this.idUser = userGroup.getUser().getId();
        this.idGroup = userGroup.getGroup().getId();
        this.role = userGroup.getRole();
    }

}
