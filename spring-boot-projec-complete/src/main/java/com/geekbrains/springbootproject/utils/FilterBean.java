package com.geekbrains.springbootproject.utils;

import com.geekbrains.springbootproject.entities.Product;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

@Component
public class FilterBean {
    private Specification<Product> spec;
    private String filterDefinition;
}
