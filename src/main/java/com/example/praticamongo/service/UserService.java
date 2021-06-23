package com.example.praticamongo.service;

import com.example.praticamongo.dto.AddressDTO;
import com.example.praticamongo.dto.UserDTO;
import com.example.praticamongo.repository.AddressRepository;
import com.example.praticamongo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    AddressRepository addressRepository;

    public  UserService(UserRepository userRepository, AddressRepository addressRepository){
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public UserDTO createUser(UserDTO userDTO){

        AddressDTO addressDTO = addressRepository.save(userDTO.getAddress());
        userDTO.setAddress(addressDTO);

        return userRepository.save(userDTO);
    }

    public List<UserDTO> findAllUser(){
        return userRepository.findAll();
    }

    public UserDTO editUser(UserDTO userDTO, String id){
        UserDTO userEdit =  userRepository.findById(id).orElse(null);
        assert userEdit != null;
        AddressDTO addressEdit = new AddressDTO(userEdit.getAddress().getId(),
                userDTO.getAddress().getZipcode(),
                userDTO.getAddress().getZipcode());

        userDTO.setAddress(addressEdit);
        userDTO.setId(id);

        addressRepository.save(addressEdit);
        userRepository.save(userDTO);

        return userDTO;
    }

    public void deleteUser(String id){
        UserDTO userDelete = userRepository.findById(id).orElse(null);
        assert userDelete != null;
        userRepository.delete(userDelete);
    }
}
