package com.zkybe.app.business.services;

import com.zkybe.app.dtos.UserDTO;
import com.zkybe.app.models.User;
import com.zkybe.app.persistence.mappers.UserMapper;
import com.zkybe.app.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> userMapper.mapToDto(user))
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUser(Integer id) {
        return userRepository.findById(id)
                .map(user -> userMapper.mapToDto(user));
    }

    public UserDTO addUser(UserDTO userDto) {
        return userMapper.mapToDto(userRepository
                .save(userMapper.mapToModel(userDto)));
    }

    public Optional<UserDTO> getUserByNickname(String nickname) {
        return userRepository.getUserByNickname(nickname)
                .map(user -> userMapper.mapToDto(user));
    }

    public String deleteUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return "Success";
        } else return "Deletion failed";
    }

    public int updateUserPassword(Integer id, String password) {
        return userRepository.updatePassword(id, password);
    }

    public int updateUserNickname(Integer id, String nickname, String password) {
        Optional<User> user = userRepository.findById(id);
        int returnValue = 0;
        if (user.isPresent() && Objects.equals(user.get().getPassword(), password)) {
            returnValue = userRepository.updateNickname(id, nickname);
        }
        return returnValue;
    }
}
