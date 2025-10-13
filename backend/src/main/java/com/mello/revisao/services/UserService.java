package com.mello.revisao.services;

import com.mello.revisao.domain.usermodel.UserModel;
import com.mello.revisao.repository.UserRepository;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public UserModel buscarPorID(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID " + id + " não encontrado!"));
    }

    public UserModel buscarPorUsername(String username) {
        return userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    }

}
