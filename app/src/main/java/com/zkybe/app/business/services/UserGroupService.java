package com.zkybe.app.business.services;

import com.zkybe.app.dtos.UserGroupDTO;
import com.zkybe.app.persistence.mappers.UserGroupMapper;
import com.zkybe.app.persistence.repositories.GroupRepository;
import com.zkybe.app.persistence.repositories.UserGroupRepository;
import com.zkybe.app.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserGroupService {
    @Autowired
    private UserGroupRepository userGroupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserGroupMapper userGroupMapper;

    public List<UserGroupDTO> getAllUserGroups() {
        return userGroupRepository.findAll().stream()
                .map(ug -> userGroupMapper.mapToDto(ug))
                .collect(Collectors.toList());
    }

    public UserGroupDTO addUserGroup(UserGroupDTO userGroupDTO) {
        return userGroupMapper.mapToDto(userGroupRepository
                .save(userGroupMapper.mapToModel(userGroupDTO, userRepository, groupRepository)));
    }

}
