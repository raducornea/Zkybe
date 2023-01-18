package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.UserGroupService;
import com.zkybe.app.dtos.UserGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
@CrossOrigin(origins = "http://localhost:4200")
public class UserGroupController {
    @Autowired
    private UserGroupService userGroupService;

    @GetMapping("user_groups")
    public List<UserGroupDTO> getAllUserGroups() {
        return userGroupService.getAllUserGroups();
    }

    @PutMapping("/add_user_to_group")
    public ResponseEntity<UserGroupDTO> addUserToGroup(@RequestBody UserGroupDTO userGroupDTO) {
        return new ResponseEntity<>(userGroupService.addUserGroup(userGroupDTO), new HttpHeaders(), HttpStatus.OK);
    }
}
