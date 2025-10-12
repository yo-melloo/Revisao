package com.mello.revisao.repository;

import com.mello.revisao.domain.usermodel.UserModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByLogin(String login);
}
