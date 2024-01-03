package com.estudos.projectwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.projectwebservice.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
