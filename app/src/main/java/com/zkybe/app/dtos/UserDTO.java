package com.zkybe.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkybe.app.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("password")
    private String password;

    public UserDTO(Integer id, String nickname, String password) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
    }
}
