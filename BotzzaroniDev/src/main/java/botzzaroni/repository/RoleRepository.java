package botzzaroni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import botzzaroni.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
