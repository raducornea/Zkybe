package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.DeletedGroupService;
import com.zkybe.app.dtos.DeletedGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
@CrossOrigin(origins = "http://localhost:4200")
public class DeletedGroupController {
    @Autowired
    private DeletedGroupService deletedGroupService;

    @GetMapping("/deleted_groups")
    public List<DeletedGroupDTO> getAllDeletedGroups() {
        return deletedGroupService.getDeletedGroups();
    }

    @PutMapping("{id}/delete_group")
    public ResponseEntity<DeletedGroupDTO> updatePassword(@PathVariable Integer id) throws Exception {
        DeletedGroupDTO deletedGroupDTO = new DeletedGroupDTO();
        deletedGroupDTO.setIdGroup(id);
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        deletedGroupDTO.setDeletionDate(date);
        return new ResponseEntity<>(deletedGroupService.addDeletedGroup(deletedGroupDTO), new HttpHeaders(), HttpStatus.OK);
    }

}
