package com.develop.challenge.bookapi.infrastructure.adapter.repository.jpa;

import com.develop.challenge.bookapi.infrastructure.adapter.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Find user by username
     * @param username username value
     * @return user entity object
     */
    UserEntity findByUsername(String username);

}
