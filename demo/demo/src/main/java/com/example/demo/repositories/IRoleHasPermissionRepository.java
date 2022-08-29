package com.example.demo.repositories;

import com.example.demo.entities.RoleHasPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleHasPermissionRepository extends JpaRepository<RoleHasPermission,Long> {
}
