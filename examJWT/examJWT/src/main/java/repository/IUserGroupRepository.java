package repository;

import entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserGroupRepository   extends JpaRepository<UserGroup, Long> {
}
