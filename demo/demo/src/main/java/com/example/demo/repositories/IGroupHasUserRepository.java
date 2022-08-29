package com.example.demo.repositories;

import com.example.demo.entities.GroupHasUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupHasUserRepository extends JpaRepository<GroupHasUser,Long> {
}
