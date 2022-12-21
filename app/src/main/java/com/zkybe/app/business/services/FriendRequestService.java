package com.zkybe.app.business.services;

import com.zkybe.app.dtos.FriendRequestDTO;
import com.zkybe.app.models.FriendRequest;
import com.zkybe.app.persistence.mappers.FriendRequestMapper;
import com.zkybe.app.persistence.repositories.FriendRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendRequestService {
    @Autowired
    private FriendRequestRepository friendRequestRepository;
    @Autowired
    private FriendRequestMapper friendRequestMapper;

    public List<FriendRequestDTO> getFriendRequests() {
        return friendRequestRepository.findAll().stream()
                .map(requests -> friendRequestMapper.mapToDto(requests))
                .collect(Collectors.toList());
    }

    public FriendRequestDTO sendFriendRequest(Integer senderId, Integer receiverId) {
        return friendRequestMapper.mapToDto(friendRequestRepository
                .save(friendRequestMapper.mapToModel(new FriendRequestDTO(senderId, receiverId, false))));
    }

}
