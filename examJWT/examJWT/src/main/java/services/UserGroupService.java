package services;

import entity.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IUserGroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserGroupService implements IUserGroupService{
    @Autowired
    private IUserGroupRepository _userGroupRepository;

    @Override
    public UserGroup addUser(UserGroup entity) {
        return _userGroupRepository.save(entity);
    }

    @Override
    public UserGroup updateUser(UserGroup entity) {
        return _userGroupRepository.save(entity);
    }

    @Override
    public void deleteUser(Long Id) {
        _userGroupRepository.deleteById(Id);
    }

    @Override
    public Optional<UserGroup> findByID(Long Id) {
        return _userGroupRepository.findById(Id);
    }

    @Override
    public List<UserGroup> findAll() {
        return _userGroupRepository.findAll();
    }
}
