package com.zkybe.app.business.services;

import com.zkybe.app.dtos.DeletedGroupDTO;
import com.zkybe.app.persistence.mappers.DeletedGroupMapper;
import com.zkybe.app.persistence.repositories.DeletedGroupRepository;
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

    public List<DeletedGroupDTO> getDeletedGroups() {
        return deletedGroupRepository.findAll().stream()
                .map(group -> deletedGroupMapper.mapToDto(group))
                .collect(Collectors.toList());
    }
}
