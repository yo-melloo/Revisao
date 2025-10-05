package com.mello.revisao.dtos;

import com.mello.revisao.domain.usermodel.UserRole;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotNull(message = "é obrigatório definir Login") String login,
        @NotNull(message = "é obrigatório definir Senha") String password,
        @NotNull(message = "é obrigatório definir Role") UserRole role,
        @NotNull(message = "é obrigatório definir Nome") String name,
        @NotNull(message = "é obrigatório definir Email") String email) {
}
