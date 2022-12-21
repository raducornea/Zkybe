package com.zkybe.app.business.services;

import com.zkybe.app.dtos.UserPreferencesDTO;
import com.zkybe.app.persistence.mappers.UserPreferencesMapper;
import com.zkybe.app.persistence.repositories.UserPreferencesRepository;
import com.zkybe.app.persistence.repositories.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    public List<UserPreferencesDTO> getUsersPreferences() {
        return userPreferencesRepository.findAll().stream()
                .map(preferences -> userPreferencesMapper.mapToDto(preferences))
                .collect(Collectors.toList());
    }

    public Optional<UserPreferencesDTO> getUserPreferences(Integer id) {
        return userPreferencesRepository.findById(id)
                .map(userPref -> userPreferencesMapper.mapToDto(userPref));

    }

    public int updateTheme(Integer id, String theme) {
        return userPreferencesRepository.updateTheme(id, theme);
    }

    public int updateNotifications(Integer id, Boolean notifications) {
        return userPreferencesRepository.updateNotifications(id, notifications);
    }

    public UserPreferencesDTO addUserPreferences(UserPreferencesDTO userPreferencesDTO) {
        System.out.println("ID-ul care cica e null: " + userPreferencesDTO.getId());
        System.out.println("ar trebui sa mearga " + userRepository.findById(userPreferencesDTO.getId()).get().getId());
        return userPreferencesMapper.mapToDto(userPreferencesRepository
                .save(userPreferencesMapper.mapToModel(userPreferencesDTO)));

    }
}
