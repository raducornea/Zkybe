package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.FriendRequestService;
import com.zkybe.app.dtos.FriendRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
public class FriendRequestController {
    @Autowired
    private FriendRequestService friendRequestService;

    @GetMapping("/friend_requests")
    public List<FriendRequestDTO> getAllFriendRequests() {
        return friendRequestService.getFriendRequests();
    }
}
