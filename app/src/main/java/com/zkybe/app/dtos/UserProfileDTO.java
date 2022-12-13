package com.zkybe.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkybe.app.models.User;
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

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("password")
    private String password;

    @JsonProperty("profilePicture")
    private Blob profilePicture;

    @JsonProperty("status")
    private String status;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("birthdate")
    private Date birthDate;

    public UserProfileDTO(UserProfile userProfile) {
        this.id = userProfile.getId();
        this.nickname = userProfile.getUser().getNickname();
        this.password = userProfile.getUser().getPassword();
        this.profilePicture = userProfile.getProfilePicture();
        this.status = userProfile.getStatus();
        this.lastName = userProfile.getLastName();
        this.firstName = userProfile.getFirstName();
        this.birthDate = userProfile.getBirthDate();
    }

    public UserProfileDTO(Integer id, String nickname, String password,
                          Blob profilePicture, String status, String lastName,
                          String firstName, Date birthDate) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.profilePicture = profilePicture;
        this.status = status;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

}
