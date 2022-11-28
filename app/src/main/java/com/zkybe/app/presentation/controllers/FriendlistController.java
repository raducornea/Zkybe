package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.FriendlistService;
import com.zkybe.app.dtos.FriendlistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
public class FriendlistController {
    @Autowired
    private FriendlistService friendlistService;

    @GetMapping("/friendlists")
    public List<FriendlistDTO> getAllFriendlists() {
        return friendlistService.getFriendlists();
    }
}
