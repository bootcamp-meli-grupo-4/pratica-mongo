package com.example.praticamongo.dto;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "address")
public class AddressDTO {

    @Id
    private String id;
    private String street;
    private String zipcode;

    public AddressDTO(String id, String street, String zipcode) {
        this.id = id;
        this.street = street;
        this.zipcode = zipcode;
    }
}
