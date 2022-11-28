package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.UserGroupDTO;
import com.zkybe.app.models.UserGroup;
import org.springframework.stereotype.Component;

@Component
public class UserGroupMapper {
    public UserGroupDTO mapToDto(UserGroup userGroup)
    {
        return new UserGroupDTO(userGroup);
    }
}
