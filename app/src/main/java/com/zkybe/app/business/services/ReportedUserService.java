package com.zkybe.app.business.services;

import com.zkybe.app.dtos.ReportedUserDTO;
import com.zkybe.app.persistence.mappers.ReportedUserMapper;
import com.zkybe.app.persistence.repositories.ReportedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportedUserService {
    @Autowired
    private ReportedUserRepository reportedUserRepository;
    @Autowired
    private ReportedUserMapper reportedUserMapper;

    public List<ReportedUserDTO> getAllReportedUsers() {
        return reportedUserRepository.findAll().stream()
                .map(reported -> reportedUserMapper.mapToDto(reported))
                .collect(Collectors.toList());
    }
}
