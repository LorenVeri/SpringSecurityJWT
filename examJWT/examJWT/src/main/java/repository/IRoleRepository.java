package repository;

import entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository  extends JpaRepository<Role, Long> {
}
