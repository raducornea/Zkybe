package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.UserGroupDTO;
import com.zkybe.app.models.UserGroup;
import com.zkybe.app.persistence.repositories.GroupRepository;
import com.zkybe.app.persistence.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserGroupMapper {

    public UserGroupDTO mapToDto(UserGroup userGroup) {
        return new UserGroupDTO(userGroup);
    }

    public UserGroup mapToModel(UserGroupDTO userGroupDTO, UserRepository userRepository,
                                GroupRepository groupRepository) {
        return new UserGroup(userRepository.findById(userGroupDTO.getIdUser()),
                groupRepository.findById(userGroupDTO.getIdGroup()),
                userGroupDTO.getRole());
    }
}
