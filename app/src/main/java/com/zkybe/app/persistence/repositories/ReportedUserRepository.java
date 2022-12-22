package com.zkybe.app.persistence.repositories;

import com.zkybe.app.models.ReportedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportedUserRepository extends JpaRepository<ReportedUser, Integer> {
}
