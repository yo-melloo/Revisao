package com.mello.revisao.dtos;

import com.mello.revisao.domain.usermodel.UserModel;

public record UserProfileDTO(
        String avatar,
        String name,
        String username,
        String email) {

    // Construtor auxiliar para converter de UserModel para UserProfileDTO
    public UserProfileDTO(UserModel user) {
        this(
                user.getAvatar(),
                user.getName(),
                user.getUsername(),
                user.getEmail());
    }
}
