package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.UserPreferencesDTO;
import com.zkybe.app.models.User;
import com.zkybe.app.models.UserPreferences;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserPreferencesMapper {
    public UserPreferencesDTO mapToDto(UserPreferences userPreferences) {
        return new UserPreferencesDTO(userPreferences);
    }
    public UserPreferences mapToModel(UserPreferencesDTO userPreferencesDTO, Optional<User> user)
    {
        return new UserPreferences(userPreferencesDTO,user);
    }
}
