package com.ewangclarks.userservice.common.repository;

import com.ewangclarks.userservice.common.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUserId(String userId);
}
