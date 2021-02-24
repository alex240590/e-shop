package ru.gb.eshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.eshop.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
