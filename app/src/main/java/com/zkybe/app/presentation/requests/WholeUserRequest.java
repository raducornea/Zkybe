package com.zkybe.app.presentation.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WholeUserRequest {
    private String password;
    private String nickname;
    private Blob profilePicture;
    private String status;
    private String lastName;
    private String firstName;
    private Date birthdate;
}
