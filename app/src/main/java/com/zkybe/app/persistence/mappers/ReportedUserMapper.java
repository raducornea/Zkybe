package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.ReportedUserDTO;
import com.zkybe.app.models.ReportedUser;
import org.springframework.stereotype.Component;

@Component
public class ReportedUserMapper {
    public ReportedUserDTO mapToDto(ReportedUser reportedUser)
    {
        return new ReportedUserDTO(reportedUser);
    }
}
