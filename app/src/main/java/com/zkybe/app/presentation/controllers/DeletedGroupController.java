package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.DeletedGroupService;
import com.zkybe.app.dtos.DeletedGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
public class DeletedGroupController {
    @Autowired
    private DeletedGroupService deletedGroupService;

    @GetMapping("/deleted_groups")
    public List<DeletedGroupDTO> getAllDeletedGroups() {
        return deletedGroupService.getDeletedGroups();
    }
}
