package com.example.demo.repositories;

import com.example.demo.entities.GroupUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupUserRepository extends JpaRepository<GroupUser,Long> {
}
