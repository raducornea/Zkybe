package com.zkybe.app.business.services;

import com.zkybe.app.dtos.FriendlistDTO;
import com.zkybe.app.persistence.mappers.FriendlistMapper;
import com.zkybe.app.persistence.repositories.FriendlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendlistService {
    @Autowired
    private FriendlistRepository friendlistRepository;

    @Autowired
    private FriendlistMapper friendlistMapper;

    public List<FriendlistDTO> getFriendlists()
    {
        return friendlistRepository.findAll().stream()
                .map(friendlist -> friendlistMapper.mapToDto(friendlist))
                .collect(Collectors.toList());
    }
}
