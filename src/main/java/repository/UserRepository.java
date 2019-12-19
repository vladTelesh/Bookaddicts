package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
