package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.ReportedUserService;
import com.zkybe.app.dtos.ReportedUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportedUserController {
    @Autowired
    private ReportedUserService reportedUserService;

    @GetMapping("/reported_users")
    public List<ReportedUserDTO> getAllReportedUsers() {
        return reportedUserService.getAllReportedUsers();
    }

    @PutMapping("/{id}/report_user")
    public ResponseEntity<ReportedUserDTO> addBlockedUser(@RequestBody ReportedUserDTO reportedUserDTO, @PathVariable Integer id) {
        reportedUserDTO.setUserId(id);
        System.out.println(reportedUserDTO.getReportedUserId());
        System.out.println(reportedUserDTO.getUserId());
        return new ResponseEntity<>(reportedUserService.addReportedUser(reportedUserDTO), new HttpHeaders(), HttpStatus.OK);
    }
}
