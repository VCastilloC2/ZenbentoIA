package com.App.IA.Entity.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Rol {
    Admin("Administrador"),
    User("Usuario");

    private final String descripcion;

}