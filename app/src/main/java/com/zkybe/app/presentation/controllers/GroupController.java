package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.GroupService;
import com.zkybe.app.dtos.GroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<GroupDTO> getAllGroups() {
        return groupService.getGroups();
    }
}
