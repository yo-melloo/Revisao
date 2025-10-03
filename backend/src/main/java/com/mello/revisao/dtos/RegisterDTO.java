package com.mello.revisao.dtos;

import com.mello.revisao.domain.usermodel.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
