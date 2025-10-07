package com.mello.revisao.services;

import com.mello.revisao.domain.usermodel.UserModel;
import com.mello.revisao.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> mostrarUsuarios() {
        return userRepository.findAll();
    }
}
