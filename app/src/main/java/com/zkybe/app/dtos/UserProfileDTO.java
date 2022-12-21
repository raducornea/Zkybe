package com.zkybe.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkybe.app.models.UserProfile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("profilePicture")
    private Blob profilePicture;

    @JsonProperty("status")
    private String status;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("birthdate")
    private Date birthdate;

    public UserProfileDTO(UserProfile userProfile) {
        this.id = userProfile.getId();
        this.profilePicture = userProfile.getProfilePicture();
        this.status = userProfile.getStatus();
        this.lastName = userProfile.getLastName();
        this.firstName = userProfile.getFirstName();
        this.birthdate = userProfile.getBirthDate();
    }

    public UserProfileDTO(Integer id, String nickname, String password,
                          Blob profilePicture, String status, String lastName,
                          String firstName, Date birthDate) {
        this.id = id;
        this.profilePicture = profilePicture;
        this.status = status;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthdate = birthDate;
    }

}
