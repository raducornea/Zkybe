package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.FriendRequestDTO;
import com.zkybe.app.models.FriendRequest;
import org.springframework.stereotype.Component;

@Component
public class FriendRequestMapper {
    public FriendRequestDTO mapToDto(FriendRequest friendRequest) {
        return new FriendRequestDTO(friendRequest);
    }

    public FriendRequest mapToModel(FriendRequestDTO friendRequestDTO) {
        return new FriendRequest(friendRequestDTO);
    }
}
