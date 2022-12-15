package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.BlockedUserDTO;
import com.zkybe.app.models.BlockedUser;
import org.springframework.stereotype.Component;

@Component
public class BlockedUserMapper {
    public BlockedUserDTO mapToDto(BlockedUser blockedUser) {
        return new BlockedUserDTO(blockedUser);
    }
}
