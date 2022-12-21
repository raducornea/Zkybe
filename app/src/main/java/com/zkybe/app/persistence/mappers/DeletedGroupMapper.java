package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.DeletedGroupDTO;
import com.zkybe.app.models.DeletedGroup;
import org.springframework.stereotype.Component;

@Component
public class DeletedGroupMapper {
    public DeletedGroupDTO mapToDto(DeletedGroup deletedGroup) {
        return new DeletedGroupDTO(deletedGroup);
    }

    public DeletedGroup mapToModel(DeletedGroupDTO deletedGroupDTO) {
        return new DeletedGroup(deletedGroupDTO);
    }
}
