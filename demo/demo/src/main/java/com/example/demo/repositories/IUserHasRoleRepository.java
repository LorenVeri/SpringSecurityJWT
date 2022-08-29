package com.example.demo.repositories;

import com.example.demo.entities.UserHasRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserHasRoleRepository extends JpaRepository<UserHasRole, Long> {
}
