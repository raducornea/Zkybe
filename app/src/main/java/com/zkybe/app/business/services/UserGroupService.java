package com.zkybe.app.business.services;

import com.zkybe.app.dtos.UserGroupDTO;
import com.zkybe.app.persistence.mappers.UserGroupMapper;
import com.zkybe.app.persistence.repositories.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserGroupService {
    @Autowired
    private UserGroupRepository userGroupRepository;
    @Autowired
    private UserGroupMapper userGroupMapper;

    public List<UserGroupDTO> getAllUserGroups() {
        return userGroupRepository.findAll().stream()
                .map(ug -> userGroupMapper.mapToDto(ug))
                .collect(Collectors.toList());
    }

}
