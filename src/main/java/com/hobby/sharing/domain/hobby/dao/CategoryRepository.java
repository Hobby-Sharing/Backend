package com.hobby.sharing.domain.hobby.dao;

import com.hobby.sharing.domain.hobby.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}