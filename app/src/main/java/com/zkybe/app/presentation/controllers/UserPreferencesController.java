package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.UserPreferencesService;
import com.zkybe.app.dtos.UserPreferencesDTO;
import com.zkybe.app.presentation.requests.UserPreferencesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
@CrossOrigin(origins = "http://localhost:4200")
public class UserPreferencesController {
    @Autowired
    private UserPreferencesService userPreferencesService;

    @GetMapping("/preferences")
    public List<UserPreferencesDTO> getAllPreferences() {
        return userPreferencesService.getUsersPreferences();
    }

    @GetMapping("users/{id}/preferences")
    public ResponseEntity<UserPreferencesDTO> getUserPreferences(@PathVariable Integer id) {
        return userPreferencesService.getUserPreferences(id)
                .map(value -> new ResponseEntity<>(value, new HttpHeaders(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND));
    }

    @PutMapping("users/{id}/preferences/theme")
    public ResponseEntity<String> updatePassword(@PathVariable Integer id, @RequestBody UserPreferencesRequest request) {
        int updateResponse = userPreferencesService.updateTheme(id, request.getTheme());
        if (updateResponse == 1)
            return new ResponseEntity<>("Updated", new HttpHeaders(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed", new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("users/{id}/preferences/notifications")
    public ResponseEntity<String> updateNotifications(@PathVariable Integer id, @RequestBody UserPreferencesRequest request) {
        int updateResponse = userPreferencesService.updateNotifications(id, request.getNotifications());
        if (updateResponse == 1)
            return new ResponseEntity<>("Updated", new HttpHeaders(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed", new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("users/{id}/add_user_preferences")
    public ResponseEntity<UserPreferencesDTO> addUser(@PathVariable Integer id, @RequestBody UserPreferencesDTO userPreferencesDTO) {
        userPreferencesDTO.setId(id);
        return new ResponseEntity<>(userPreferencesService.addUserPreferences(userPreferencesDTO), new HttpHeaders(), HttpStatus.OK);
    }
}
