package com.zkybe.app.models;

import com.zkybe.app.dtos.UserPreferencesDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_preferences")
public class UserPreferences {
    @Id
    @Column(name = "user_id")
    private Integer id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User user;

    @Column(name = "theme", nullable = false)
    private String theme;

    @Column(name = "notifications", nullable = false)
    private Boolean notifications;

    public UserPreferences(UserPreferencesDTO userPreferencesDTO) {
        this.id = userPreferencesDTO.getId();
        this.theme = userPreferencesDTO.getTheme();
        this.notifications = userPreferencesDTO.getNotifications();
    }

    public UserPreferences(UserPreferencesDTO userPreferencesDTO, Optional<User> user) {
        this.id = userPreferencesDTO.getId();
        this.theme = userPreferencesDTO.getTheme();
        this.notifications = userPreferencesDTO.getNotifications();
        user.ifPresent(value -> this.user = value);
    }
}
