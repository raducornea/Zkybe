package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.GroupDTO;
import com.zkybe.app.models.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {
    public GroupDTO mapToDto(Group group) {
        return new GroupDTO(group);
    }

    public Group mapToModel(GroupDTO groupDTO) {
        return new Group(groupDTO);
    }
}
