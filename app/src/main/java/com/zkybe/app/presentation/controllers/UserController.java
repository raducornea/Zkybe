package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.DeletedGroupService;
import com.zkybe.app.business.services.UserProfileService;
import com.zkybe.app.business.services.UserService;
import com.zkybe.app.dtos.UserDTO;
import com.zkybe.app.presentation.requests.UserRequest;
import com.zkybe.app.presentation.requests.WholeUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/zkybe/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {
        return userService.getUser(id)
                .map(value -> new ResponseEntity<>(value, new HttpHeaders(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND));
    }

    @GetMapping(params = {"nickname"})
    public ResponseEntity<UserDTO> getUserByNickname(@RequestParam String nickname) {
        return userService.getUserByNickname(nickname).map(value -> new ResponseEntity<>(value, new HttpHeaders(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add_user")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto) {
        return new ResponseEntity<>(userService.addUser(userDto), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/add_user_with_profile")
    public ResponseEntity<String> addUserWithProfile(@RequestBody WholeUserRequest wholeUserRequest)
    {
        Optional<UserDTO> user = userService.getUserByNickname(wholeUserRequest.getNickname());

        if(!user.isPresent()) {
            userService.addUser(new UserDTO(null, wholeUserRequest.getNickname(), wholeUserRequest.getPassword()));
            if (userService.getUserByNickname(wholeUserRequest.getNickname()).isPresent()) {
                userProfileService.createProfile(userService.getUserByNickname(wholeUserRequest.getNickname()).get().getId(),
                        wholeUserRequest.getProfilePicture(), wholeUserRequest.getStatus(),
                        wholeUserRequest.getLastName(), wholeUserRequest.getFirstName(), wholeUserRequest.getBirthdate());
                return new ResponseEntity<>("User with profile added", new HttpHeaders(), HttpStatus.OK);
            } else
                return new ResponseEntity<>("There was a problem", new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>("We already have an user with this nickname", new HttpHeaders(), HttpStatus.CONFLICT);

    }

    @PutMapping("/{id}/change_password")
    public ResponseEntity<String> updatePassword(@PathVariable Integer id, @RequestBody UserRequest request) {
        int updateResponse = userService.updateUserPassword(id, request.getPassword());
        if (updateResponse == 1)
            return new ResponseEntity<>("Updated", new HttpHeaders(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed", new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/change_nickname")
    public ResponseEntity<String> updateNickname(@PathVariable Integer id, @RequestBody UserRequest request) {
        int updateResponse = userService.updateUserNickname(id, request.getNickname(), request.getPassword());
        if (updateResponse == 1)
            return new ResponseEntity<>("Updated", new HttpHeaders(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed", new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.deleteUser(id), new HttpHeaders(), HttpStatus.OK);
    }

}
