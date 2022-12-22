package com.zkybe.app.persistence.repositories;

import com.zkybe.app.models.BlockedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockedUserRepository extends JpaRepository<BlockedUser, Integer> {
}
