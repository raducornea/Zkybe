package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.FriendlistService;
import com.zkybe.app.dtos.FriendlistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
@CrossOrigin(origins = "http://localhost:4200")
public class FriendlistController {
    @Autowired
    private FriendlistService friendlistService;

    @GetMapping("/friendlists")
    public List<FriendlistDTO> getAllFriendlists() {
        return friendlistService.getFriendlists();
    }

    @PutMapping("{id}/add_friend/{idFriend}")
    public ResponseEntity<FriendlistDTO> addFriend(@PathVariable Integer id, @PathVariable Integer idFriend) throws Exception {
        friendlistService.addToFriendlist(idFriend, id);//daca incerc sa adaug prietenul 1 la 2 sa se adauge si vice versa
        return new ResponseEntity<>(friendlistService.addToFriendlist(id, idFriend), new HttpHeaders(), HttpStatus.OK);
    }
}
