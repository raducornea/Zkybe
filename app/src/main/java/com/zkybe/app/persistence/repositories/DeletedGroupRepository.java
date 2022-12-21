package com.zkybe.app.persistence.repositories;

import com.zkybe.app.models.DeletedGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeletedGroupRepository extends JpaRepository<DeletedGroup, Integer> {
}
