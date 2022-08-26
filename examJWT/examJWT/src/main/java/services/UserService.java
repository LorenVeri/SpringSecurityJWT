package services;

import entity.CustomUserDetail;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import repository.IUserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class UserService implements IUserService, UserDetailsService {
    @Autowired
    private IUserRepository _userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = _userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return new CustomUserDetail(user);
    }

    @Override
    public User addUser(User entity) {
        return _userRepository.save(entity);
    }

    @Override
    public User updateUser(User entity) {
        return _userRepository.save(entity);
    }

    @Override
    public void deleteUser(Long Id) {
        _userRepository.deleteById(Id);
    }

    @Override
    public Optional<User> findByID(Long Id) {
        return _userRepository.findById(Id);
    }

    @Override
    public List<User> findAll() {
        return _userRepository.findAll();
    }
}
