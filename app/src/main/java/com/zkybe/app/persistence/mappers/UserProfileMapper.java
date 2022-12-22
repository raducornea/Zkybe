package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.UserProfileDTO;
import com.zkybe.app.models.UserProfile;
import org.springframework.stereotype.Component;

import java.sql.Blob;
import java.util.Date;

@Component
public class UserProfileMapper {
    public UserProfileDTO mapToDto(UserProfile userProfile) {
        return new UserProfileDTO(userProfile);
    }

    public UserProfile mapToModel(UserProfileDTO userProfileDto) {
        return new UserProfile(userProfileDto);
    }

    public UserProfileDTO mapToDto(Integer id, String nickname, String password,
                                   Blob profilePicture, String status, String lastName, String firstName, Date birthdate) {
        return new UserProfileDTO(id, nickname, password, profilePicture, status, lastName, firstName, birthdate);
    }
}
