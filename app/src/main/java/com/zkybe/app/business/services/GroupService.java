package com.zkybe.app.business.services;

import com.zkybe.app.dtos.GroupDTO;
import com.zkybe.app.persistence.mappers.GroupMapper;
import com.zkybe.app.persistence.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupMapper groupMapper;

    public List<GroupDTO> getGroups() {
        return groupRepository.findAll().stream()
                .map(group -> groupMapper.mapToDto(group))
                .collect(Collectors.toList());
    }

    public GroupDTO addGroup(GroupDTO groupDTO) {
        return groupMapper.mapToDto(groupRepository
                .save(groupMapper.mapToModel(groupDTO)));
    }

}

