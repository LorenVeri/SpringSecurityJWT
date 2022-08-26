package services;


import entity.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    Role addUser(Role entity);
    Role updateUser(Role entity);
    void deleteUser(Long Id);
    Optional<Role> findByID(Long Id);
    List<Role> findAll();
}
