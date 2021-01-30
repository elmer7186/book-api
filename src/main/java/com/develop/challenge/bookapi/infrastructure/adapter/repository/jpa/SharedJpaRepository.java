package com.develop.challenge.bookapi.infrastructure.adapter.repository.jpa;

import com.develop.challenge.bookapi.infrastructure.adapter.repository.entity.SharedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedJpaRepository extends JpaRepository<SharedEntity, Long> {

}
