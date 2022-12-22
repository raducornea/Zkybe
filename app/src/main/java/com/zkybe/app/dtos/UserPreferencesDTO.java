package com.zkybe.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkybe.app.models.UserPreferences;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserPreferencesDTO {
    @JsonProperty("user_id")
    private Integer id;

    @JsonProperty("theme")
    private String theme;

    @JsonProperty("notifications")
    private Boolean notifications;

    public UserPreferencesDTO(UserPreferences userPreferences) {
        this.id = userPreferences.getId();
        this.theme = userPreferences.getTheme();
        this.notifications = userPreferences.getNotifications();
    }
}
