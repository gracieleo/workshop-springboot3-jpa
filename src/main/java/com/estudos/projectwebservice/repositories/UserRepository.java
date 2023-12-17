package com.estudos.projectwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.projectwebservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
