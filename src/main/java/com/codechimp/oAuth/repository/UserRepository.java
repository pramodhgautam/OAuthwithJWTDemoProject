package com.codechimp.oAuth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.codechimp.oAuth.userDocument.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    boolean existsByUserName(String username);
    Optional<User> findByUserName(String username);

}