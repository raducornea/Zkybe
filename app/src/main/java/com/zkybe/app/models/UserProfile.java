package com.zkybe.app.models;

import com.zkybe.app.dtos.UserProfileDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "profiles")
public class UserProfile {
    @Id
    @Column(name = "user_id")
    private Integer id;

    @JsonIgnore
    @OneToOne
    // @MapsId
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User user;


    @Column(name = "profile_picture", nullable = true)
    private Blob profilePicture;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "birthdate", nullable = false)
    private Date birthDate;

    public UserProfile(UserProfileDTO userProfileDTO) {
        this.id = userProfileDTO.getId();
        this.profilePicture = userProfileDTO.getProfilePicture();
        this.status = userProfileDTO.getStatus();
        this.lastName = userProfileDTO.getLastName();
        this.firstName = userProfileDTO.getFirstName();
        this.birthDate = userProfileDTO.getBirthdate();
    }
}
