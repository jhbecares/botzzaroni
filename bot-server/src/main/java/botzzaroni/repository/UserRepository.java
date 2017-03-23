package botzzaroni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import botzzaroni.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
