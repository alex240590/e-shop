package ru.gb.eshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.eshop.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
