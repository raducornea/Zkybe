package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.FriendRequestDTO;
import com.zkybe.app.dtos.FriendlistDTO;
import com.zkybe.app.models.FriendList;
import com.zkybe.app.models.User;
import org.springframework.stereotype.Component;

@Component
public class FriendlistMapper {
    public FriendlistDTO mapToDto(FriendList friendlist) {
        return new FriendlistDTO(friendlist);
    }
    public FriendList mapToModel(FriendlistDTO friendlistDTO){return new FriendList(friendlistDTO);}

}
