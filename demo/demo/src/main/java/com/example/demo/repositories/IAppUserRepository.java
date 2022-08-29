package com.example.demo.repositories;

import com.example.demo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
    Optional<AppUser> findByUsername(String Username);
}
