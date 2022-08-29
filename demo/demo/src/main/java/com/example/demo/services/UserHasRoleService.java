package com.example.demo.services;

import com.example.demo.entities.UserHasRole;
import com.example.demo.repositories.IUserHasRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserHasRoleService implements IUserHasRoleService {
    @Autowired
    private IUserHasRoleRepository userHasRoleRepository;

    @Override
    public UserHasRole save(UserHasRole entity) {
        return userHasRoleRepository.save(entity);
    }

    @Override
    public void delete(Long Id) {
        userHasRoleRepository.deleteById(Id);
    }

    @Override
    public Optional<UserHasRole> findById(Long Id) {
        return userHasRoleRepository.findById(Id);
    }

    @Override
    public List<UserHasRole> findAll() {
        return userHasRoleRepository.findAll();
    }
}
