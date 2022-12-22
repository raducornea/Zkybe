package com.zkybe.app.persistence.repositories;

import com.zkybe.app.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProfileRepository extends JpaRepository<UserProfile, Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE profiles SET status = ?2 WHERE user_id = ?1 ;", nativeQuery = true)
    int updateStatus(Integer id, String status);
}
