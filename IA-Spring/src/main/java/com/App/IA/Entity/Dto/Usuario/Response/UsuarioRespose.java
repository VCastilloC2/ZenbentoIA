package com.App.IA.Entity.Dto.Usuario.Response;

import jakarta.validation.constraints.NotNull;

public record UsuarioRespose(
        @NotNull String Mensaje
) {
}