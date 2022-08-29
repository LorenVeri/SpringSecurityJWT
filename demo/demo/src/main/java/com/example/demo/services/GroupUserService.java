package com.example.demo.services;

import com.example.demo.entities.GroupUser;
import com.example.demo.repositories.IGroupUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupUserService implements IGroupUserService{

    @Autowired
    private IGroupUserRepository groupdUserRepository;

    @Override
    public GroupUser save(GroupUser entity) {
        return groupdUserRepository.save(entity);
    }

    @Override
    public void delete(Long Id) {
        groupdUserRepository.deleteById(Id);
    }

    @Override
    public Optional<GroupUser> findById(Long Id) {
        return groupdUserRepository.findById(Id);
    }

    @Override
    public List<GroupUser> findAll() {
        return groupdUserRepository.findAll();
    }
}
