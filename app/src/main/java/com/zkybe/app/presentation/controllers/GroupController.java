package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.GroupService;
import com.zkybe.app.dtos.GroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe/groups")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<GroupDTO> getAllGroups() {
        return groupService.getGroups();
    }

    @PostMapping("/add_group")
    public ResponseEntity<GroupDTO> addGroup(@RequestBody GroupDTO groupDTO) {
        return new ResponseEntity<>(groupService.addGroup(groupDTO), new HttpHeaders(), HttpStatus.OK);
    }
}
