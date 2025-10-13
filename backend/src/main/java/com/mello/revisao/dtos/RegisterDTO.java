package com.mello.revisao.dtos;

import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
                @NotNull(message = "é obrigatório definir Login") String login,
                @NotNull(message = "é obrigatório definir Senha") String password,
                @NotNull(message = "é obrigatório definir Nome") String name,
                @NotNull(message = "é obrigatório definir Email") String email) {
}
