package com.estudos.projectwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.projectwebservice.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
