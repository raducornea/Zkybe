package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.BlockedUserService;
import com.zkybe.app.dtos.BlockedUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
@CrossOrigin(origins = "http://localhost:4200")
public class BlockedUserController {
    @Autowired
    private BlockedUserService blockedUserService;

    @GetMapping("/blocked_users")
    public List<BlockedUserDTO> getAllBlockedUsers() {
        return blockedUserService.getAllBlockedUsers();
    }

    @PutMapping("/{id}/add_blocked_user")
    public ResponseEntity<BlockedUserDTO> addBlockedUser(@RequestBody BlockedUserDTO blockedUserDTO, @PathVariable Integer id) {
        blockedUserDTO.setUserId(id);
        return new ResponseEntity<>(blockedUserService.addBlockedUser(blockedUserDTO), new HttpHeaders(), HttpStatus.OK);
    }

}
