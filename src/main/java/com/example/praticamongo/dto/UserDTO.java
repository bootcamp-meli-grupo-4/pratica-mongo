package com.example.praticamongo.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class UserDTO {

    @Id
    private String id;

    private String login;
    private String password;

    @DBRef
    private AddressDTO address;
}
