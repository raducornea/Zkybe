package com.zkybe.app.business.services;

import com.zkybe.app.dtos.ReportedUserDTO;
import com.zkybe.app.persistence.mappers.ReportedUserMapper;
import com.zkybe.app.persistence.repositories.ReportedUserRepository;
import com.zkybe.app.persistence.repositories.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    public List<ReportedUserDTO> getAllReportedUsers() {
        return reportedUserRepository.findAll().stream()
                .map(reported -> reportedUserMapper.mapToDto(reported))
                .collect(Collectors.toList());
    }

    public ReportedUserDTO addReportedUser(ReportedUserDTO reportedUserDTO) {
        return reportedUserMapper.mapToDto(reportedUserRepository
                .save(reportedUserMapper.mapToModel(reportedUserDTO, userRepository)));
    }
}
