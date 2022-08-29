package com.example.demo.repositories;

import com.example.demo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository  extends JpaRepository<Role,Long> {
}
