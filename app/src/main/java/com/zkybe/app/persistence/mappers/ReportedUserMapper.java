package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.ReportedUserDTO;
import com.zkybe.app.models.ReportedUser;
import com.zkybe.app.persistence.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class ReportedUserMapper {
    public ReportedUserDTO mapToDto(ReportedUser reportedUser) {
        return new ReportedUserDTO(reportedUser);
    }

    public ReportedUser mapToModel(ReportedUserDTO reportedUserDTO, UserRepository userRepository) {
        return new ReportedUser(userRepository.findById(reportedUserDTO.getUserId()),
                userRepository.findById(reportedUserDTO.getReportedUserId()), reportedUserDTO.getContent());
    }
}
