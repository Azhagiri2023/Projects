package com.giri.realestatelist.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giri.realestatelist.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    Optional<Users> findByEmail(String email);
    Optional<Users> findByName(String password);
}
