package com.zkybe.app.persistence.repositories;

import com.zkybe.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM users WHERE nickname= ?1 ;", nativeQuery = true)
    Optional<User> getUserByNickname(String nickname);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET password = ?2 WHERE id = ?1 ;", nativeQuery = true)
    int updatePassword(Integer id, String password);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET nickname = ?2 WHERE id = ?1 ;", nativeQuery = true)
    int updateNickname(Integer id, String nickname);
}
