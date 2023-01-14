package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.FriendRequestService;
import com.zkybe.app.dtos.FriendRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
@CrossOrigin(origins = "http://localhost:4200")
public class FriendRequestController {
    @Autowired
    private FriendRequestService friendRequestService;

    @GetMapping("/friend_requests")
    public List<FriendRequestDTO> getAllFriendRequests() {
        return friendRequestService.getFriendRequests();
    }

    @PutMapping("/{id}/send_friend_request/{idFriend}")
    public ResponseEntity<FriendRequestDTO> addFriend(@PathVariable Integer id, @PathVariable Integer idFriend) throws Exception {
        return new ResponseEntity<>(friendRequestService.sendFriendRequest(id, idFriend), new HttpHeaders(), HttpStatus.OK);
    }

}
