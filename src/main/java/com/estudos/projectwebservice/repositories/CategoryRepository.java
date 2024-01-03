package com.estudos.projectwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.projectwebservice.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
