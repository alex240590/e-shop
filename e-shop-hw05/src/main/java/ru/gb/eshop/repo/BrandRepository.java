package ru.gb.eshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.eshop.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
