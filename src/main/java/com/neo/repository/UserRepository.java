package com.neo.repository;

import com.neo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);
    
    User findByToken(String token);
    
    
    User findByUserNameAndPassword(String userName, String password);
    
    Long deleteById(Long id);
}