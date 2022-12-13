package com.zkybe.app.presentation.controllers;

import com.zkybe.app.business.services.ReportedUserService;
import com.zkybe.app.dtos.ReportedUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/zkybe")
public class ReportedUserController {
    @Autowired
    private ReportedUserService reportedUserService;

    @GetMapping("/reported_users")
    public List<ReportedUserDTO> getAllReportedUsers() {
        return reportedUserService.getAllReportedUsers();
    }
}
