package com.example.demo.Repository;

import com.example.demo.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsRepositoryImp implements UsRepository{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO addToDB(UserDTO userDTO) {

        return userRepository.save(userDTO);
    }
}
