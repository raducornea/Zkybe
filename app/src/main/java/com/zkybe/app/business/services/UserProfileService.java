package com.zkybe.app.business.services;

import com.zkybe.app.dtos.UserProfileDTO;
import com.zkybe.app.models.User;
import com.zkybe.app.persistence.mappers.UserProfileMapper;
import com.zkybe.app.persistence.repositories.ProfileRepository;
import com.zkybe.app.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileMapper userProfileMapper;

    public List<UserProfileDTO> getProfiles() {
        return profileRepository.findAll().stream()
                .map(profile -> userProfileMapper.mapToDto(profile))
                .collect(Collectors.toList());
    }

    public Optional<UserProfileDTO> getUserProfile(Integer id) {
        return profileRepository.findById(id)
                .map(profile -> userProfileMapper.mapToDto(profile));
    }

    public Optional<UserProfileDTO> createProfile(Integer id, Blob profilePicture, String status,
                                                  String lastName, String firstName, Date birthdate) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> userProfileMapper.mapToDto(profileRepository
                .save(userProfileMapper.mapToModel(userProfileMapper.mapToDto(id, value.getNickname(),
                        value.getPassword(), profilePicture, status, lastName, firstName, birthdate)))));

    }

    public int updateStatus(Integer id, String status) {
        return profileRepository.updateStatus(id, status);
    }

}

