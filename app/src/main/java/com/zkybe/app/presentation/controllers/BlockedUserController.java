package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.BlockedUserService;
import com.zkybe.app.dtos.BlockedUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
public class BlockedUserController {
    @Autowired
    private BlockedUserService blockedUserService;

    @GetMapping("/blocked_users")
    public List<BlockedUserDTO> getAllBlockedUsers() {
        return blockedUserService.getAllBlockedUsers();
    }
}
