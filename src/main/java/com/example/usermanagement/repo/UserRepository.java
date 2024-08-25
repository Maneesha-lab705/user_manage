package com.example.usermanagement.repo;

import com.example.usermanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
    @Query("SELECT MAX(u.id) FROM UserEntity u")
    String findMaxId();
}