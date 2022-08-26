package services;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IUserService {
    User addUser(User entity);
    User updateUser(User entity);
    void deleteUser(Long Id);
    Optional<User> findByID(Long Id);
    List<User> findAll();

    UserDetails loadUserById(Long Id);
}
