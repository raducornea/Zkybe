package com.zkybe.app.business.services;

import com.zkybe.app.dtos.UserPreferencesDTO;
import com.zkybe.app.persistence.mappers.UserPreferencesMapper;
import com.zkybe.app.persistence.repositories.UserPreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserPreferencesService {
    @Autowired
    private UserPreferencesRepository userPreferencesRepository;

    @Autowired
    private UserPreferencesMapper userPreferencesMapper;

    public List<UserPreferencesDTO> getUsersPreferences() {
        return userPreferencesRepository.findAll().stream()
                .map(preferences -> userPreferencesMapper.mapToDto(preferences))
                .collect(Collectors.toList());
    }
    public Optional<UserPreferencesDTO> getUserPreferences(Integer id)
    {
        return userPreferencesRepository.findById(id)
                .map(userPref -> userPreferencesMapper.mapToDto(userPref));

    }
    public int updateTheme(Integer id, String theme)
    {
        return userPreferencesRepository.updateTheme(id,theme);
    }
    public int updateNotifications(Integer id, Boolean notifications)
    {
        return userPreferencesRepository.updateNotifications(id,notifications);
    }
}
