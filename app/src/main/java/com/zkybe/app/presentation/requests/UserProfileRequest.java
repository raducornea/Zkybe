package com.zkybe.app.presentation.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileRequest {
    private Integer id;
    private Blob profilePicture;
    private String status;
    private String lastName;
    private String firstName;
    private Date birthdate;
}
