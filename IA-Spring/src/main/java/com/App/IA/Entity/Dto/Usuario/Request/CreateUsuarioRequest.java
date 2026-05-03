package com.App.IA.Entity.Dto.Usuario.Request;

import com.App.IA.Entity.Enum.Rol;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record CreateUsuarioRequest(
        @NotNull String nombres,
        @NotNull String apellidos,
        @NotNull String username,
        @NotNull String password,
        @NotNull Rol rol
) {
}