package com.example.praticamongo.repository;

import com.example.praticamongo.dto.AddressDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<AddressDTO, String> {
}
