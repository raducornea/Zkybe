package com.zkybe.app.business.services;

import com.zkybe.app.dtos.BlockedUserDTO;
import com.zkybe.app.persistence.mappers.BlockedUserMapper;
import com.zkybe.app.persistence.repositories.BlockedUserRepository;
import com.zkybe.app.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlockedUserService {
    @Autowired
    private BlockedUserRepository blockedUserRepository;
    @Autowired
    private BlockedUserMapper blockedUserMapper;
    @Autowired
    private UserRepository userRepository;

    public List<BlockedUserDTO> getAllBlockedUsers() {
        return blockedUserRepository.findAll().stream()
                .map(blocked -> blockedUserMapper.mapToDto(blocked))
                .collect(Collectors.toList());
    }

    public BlockedUserDTO addBlockedUser(BlockedUserDTO blockedUserDTO) {
        return blockedUserMapper.mapToDto(blockedUserRepository
                .save(blockedUserMapper.mapToModel(blockedUserDTO, userRepository)));
    }
}
