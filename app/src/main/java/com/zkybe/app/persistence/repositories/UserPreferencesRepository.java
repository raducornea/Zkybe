package com.zkybe.app.persistence.repositories;

import com.zkybe.app.models.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserPreferencesRepository extends JpaRepository<UserPreferences, Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE user_preferences SET theme = ?2 WHERE user_id = ?1 ;", nativeQuery = true)
    int updateTheme(Integer id, String theme);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_preferences SET notifications = ?2 WHERE user_id = ?1 ;", nativeQuery = true)
    int updateNotifications(Integer id, Boolean notifications);
}
