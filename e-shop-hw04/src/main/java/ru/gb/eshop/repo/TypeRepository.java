package ru.gb.eshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.eshop.entities.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
