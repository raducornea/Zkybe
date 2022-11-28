package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.UserGroupService;
import com.zkybe.app.dtos.UserGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
public class UserGroupController {
    @Autowired
    private UserGroupService userGroupService;

    @GetMapping("user_groups")
    public List<UserGroupDTO> getAllUserGroups() {
        return userGroupService.getAllUserGroups();
    }
}
