package com.zkybe.app.business.services;

import com.zkybe.app.dtos.FriendlistDTO;
import com.zkybe.app.models.User;
import com.zkybe.app.persistence.mappers.FriendlistMapper;
import com.zkybe.app.persistence.repositories.FriendlistRepository;
import com.zkybe.app.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FriendlistService {
    @Autowired
    private FriendlistRepository friendlistRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendlistMapper friendlistMapper;

    public List<FriendlistDTO> getFriendlists() {
        return friendlistRepository.findAll().stream()
                .map(friendlist -> friendlistMapper.mapToDto(friendlist))
                .collect(Collectors.toList());
    }

    public FriendlistDTO addToFriendlist(Integer userId, Integer friendId) {
//        Optional<User> user = userRepository.findById(userId);
//        Optional<User> friend = userRepository.findById(friendId);
//        if (user.isPresent() && friend.isPresent()) {
//            List<FriendlistDTO> lst = new ArrayList<>();
//            lst = user.get().addToFriendlist(friend.get()).stream()
//                    .map(us -> friendlistMapper.mapToDto(us)).collect(Collectors.toList());
//            friendlistRepository.save(user.get());
//            return lst;
//        }
//        return new ArrayList<>();
        return friendlistMapper.mapToDto(friendlistRepository
                .save(friendlistMapper.mapToModel(new FriendlistDTO(userId,friendId))));

    }

}
