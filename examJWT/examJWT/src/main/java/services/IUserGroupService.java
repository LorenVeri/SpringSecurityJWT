package services;

import entity.UserGroup;

import java.util.List;
import java.util.Optional;

public interface IUserGroupService {
    UserGroup addUser(UserGroup entity);
    UserGroup updateUser(UserGroup entity);
    void deleteUser(Long Id);
    Optional<UserGroup> findByID(Long Id);
    List<UserGroup> findAll();
}
