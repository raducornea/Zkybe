package com.zkybe.app.presentation.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
    private Integer id;
    private String password;
    private String nickname;
}
