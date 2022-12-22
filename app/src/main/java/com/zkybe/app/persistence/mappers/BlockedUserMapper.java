package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.BlockedUserDTO;
import com.zkybe.app.models.BlockedUser;
import com.zkybe.app.persistence.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class BlockedUserMapper {
    public BlockedUserDTO mapToDto(BlockedUser blockedUser) {
        return new BlockedUserDTO(blockedUser);
    }

    public BlockedUser mapToModel(BlockedUserDTO blockedUserDTO, UserRepository userRepository) {
        return new BlockedUser(userRepository.findById(blockedUserDTO.getUserId()),
                userRepository.findById(blockedUserDTO.getBlockedUserId()));
    }
}
