package com.zkybe.app.business.services;

import com.zkybe.app.dtos.DeletedGroupDTO;
import com.zkybe.app.persistence.mappers.DeletedGroupMapper;
import com.zkybe.app.persistence.repositories.DeletedGroupRepository;
import com.zkybe.app.persistence.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeletedGroupService {
    @Autowired
    private DeletedGroupRepository deletedGroupRepository;
    @Autowired
    private DeletedGroupMapper deletedGroupMapper;
    @Autowired
    private GroupRepository groupRepository;

    public List<DeletedGroupDTO> getDeletedGroups() {
        return deletedGroupRepository.findAll().stream()
                .map(group -> deletedGroupMapper.mapToDto(group))
                .collect(Collectors.toList());
    }

    public DeletedGroupDTO addDeletedGroup(DeletedGroupDTO deletedGroupDTO) throws Exception {
        if (groupRepository.findById(deletedGroupDTO.getIdGroup()).isPresent()) {
            System.out.println(deletedGroupDTO.getIdGroup());
            return deletedGroupMapper.mapToDto(deletedGroupRepository
                    .save(deletedGroupMapper.mapToModel(deletedGroupDTO)));
        } else throw new Exception("group not found");
    }
}
