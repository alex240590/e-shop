package ru.gb.eshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.eshop.entities.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
