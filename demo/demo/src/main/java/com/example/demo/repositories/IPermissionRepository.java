package com.example.demo.repositories;

import com.example.demo.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPermissionRepository extends JpaRepository<Permission,Long> {
}
