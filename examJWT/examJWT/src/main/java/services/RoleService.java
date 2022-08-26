package services;

import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService{

    @Autowired
    private IRoleRepository _roleRepository;


    @Override
    public Role addUser(Role entity) {
        return _roleRepository.save(entity);
    }

    @Override
    public Role updateUser(Role entity) {
        return _roleRepository.save(entity);
    }

    @Override
    public void deleteUser(Long Id) {
        _roleRepository.deleteById(Id);
    }

    @Override
    public Optional<Role> findByID(Long Id) {
        return _roleRepository.findById(Id);
    }

    @Override
    public List<Role> findAll() {
        return _roleRepository.findAll();
    }
}
