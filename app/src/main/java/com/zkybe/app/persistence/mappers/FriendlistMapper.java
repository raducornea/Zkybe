package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.FriendlistDTO;
import com.zkybe.app.models.User;
import org.springframework.stereotype.Component;

@Component
public class FriendlistMapper {
    public FriendlistDTO mapToDto(User friendlist) {
        return new FriendlistDTO(friendlist);
    }

}
