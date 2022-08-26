package repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryBase<T>  extends JpaRepository<T, Long> {
}
