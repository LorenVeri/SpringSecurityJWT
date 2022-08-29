package com.example.demo.services;

import com.example.demo.entities.GroupHasUser;
import com.example.demo.entities.GroupUser;
import com.example.demo.repositories.IGroupHasUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupHasUserService implements IGroupHasUserService {
    @Autowired
    private IGroupHasUserRepository groupdHasUserRepository;

    @Override
    public GroupHasUser save(GroupHasUser entity) {
        return groupdHasUserRepository.save(entity);
    }

    @Override
    public void delete(Long Id) {
        groupdHasUserRepository.deleteById(Id);
    }

    @Override
    public Optional<GroupHasUser> findById(Long id) {
        return groupdHasUserRepository.findById(id);
    }

    @Override
    public List<GroupHasUser> findAll() {
        return groupdHasUserRepository.findAll();
    }
}
