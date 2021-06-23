package com.example.praticamongo.repository;

import com.example.praticamongo.dto.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDTO, String> {

}
