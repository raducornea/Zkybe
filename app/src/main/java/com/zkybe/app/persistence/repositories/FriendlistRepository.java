package com.zkybe.app.persistence.repositories;

import com.zkybe.app.models.FriendList;
import com.zkybe.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendlistRepository extends JpaRepository<FriendList, Integer> {
}
