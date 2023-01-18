package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.UserProfileService;
import com.zkybe.app.dtos.UserProfileDTO;
import com.zkybe.app.presentation.requests.UserProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
@CrossOrigin
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/profiles")
    public List<UserProfileDTO> getAllUserProfiles() {
        return userProfileService.getProfiles();
    }

    @GetMapping("/users/{id}/profile")
    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable Integer id) {
        return userProfileService.getUserProfile(id)
                .map(value -> new ResponseEntity<>(value, new HttpHeaders(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND));
    }

    @PutMapping("users/{id}/create_profile")
    public ResponseEntity<UserProfileDTO> createProfile(@RequestBody UserProfileDTO simpleUserProfileDto,
                                                        @PathVariable Integer id) {
        System.out.println();
        return userProfileService.createProfile(id, simpleUserProfileDto.getProfilePicture(),
                        simpleUserProfileDto.getStatus(), simpleUserProfileDto.getLastName(),
                        simpleUserProfileDto.getFirstName(), simpleUserProfileDto.getBirthdate())
                .map(value -> new ResponseEntity<>(value, new HttpHeaders(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST));
    }

    @PutMapping("users/{id}/change_status")
    public ResponseEntity<String> updateStatus(@PathVariable Integer id,
                                               @RequestBody UserProfileRequest request) {
        int updateResponse = userProfileService.updateStatus(id, request.getStatus());
        if (updateResponse == 1)
            return new ResponseEntity<>("Updated", new HttpHeaders(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed", new HttpHeaders(), HttpStatus.NO_CONTENT);
    }
}
