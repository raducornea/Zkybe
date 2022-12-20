package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.DeletedGroupDTO;
import com.zkybe.app.models.DeletedGroup;
import com.zkybe.app.models.Group;
import com.zkybe.app.persistence.repositories.GroupRepository;
import org.springframework.stereotype.Component;

@Component
public class DeletedGroupMapper {
    public DeletedGroupDTO mapToDto(DeletedGroup deletedGroup) {
        return new DeletedGroupDTO(deletedGroup);
    }
    public DeletedGroup mapToModel(DeletedGroupDTO deletedGroupDTO)
    {
        //System.out.println(repository.findById(deletedGroupDTO.getIdGroup()).get().getId());
        return new DeletedGroup(deletedGroupDTO);
    }
}
