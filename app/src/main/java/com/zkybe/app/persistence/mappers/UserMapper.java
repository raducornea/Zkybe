package com.zkybe.app.persistence.mappers;

import com.zkybe.app.dtos.UserDTO;
import com.zkybe.app.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO mapToDto(User user) {
        return new UserDTO(user);
    }

    public User mapToModel(UserDTO userDTO) {
        return new User(userDTO);
    }
}
