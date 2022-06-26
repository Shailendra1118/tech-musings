package com.mycomp.batchmq.repository;

import com.mycomp.batchmq.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEntityRepository extends JpaRepository<PersonEntity, Long> {
}
