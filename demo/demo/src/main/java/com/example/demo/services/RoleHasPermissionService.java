package com.example.demo.services;

import com.example.demo.entities.RoleHasPermission;
import com.example.demo.repositories.IRoleHasPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoleHasPermissionService implements IRoleHasPermissionService{

    @Autowired
    private IRoleHasPermissionRepository roleHasPermissionRepository;

    @Override
    public List<RoleHasPermission> findAll() {
        return roleHasPermissionRepository.findAll();
    }

    @Override
    public Optional<RoleHasPermission> findById(Long id) {
        return roleHasPermissionRepository.findById(id);
    }

    @Override
    public RoleHasPermission save(RoleHasPermission roleHasPermission) {
        return roleHasPermissionRepository.save(roleHasPermission);
    }

    @Override
    public void delete(Long id) {
        roleHasPermissionRepository.deleteById(id);
    }
}
