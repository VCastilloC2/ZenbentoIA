package com.App.IA.Exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioNoEncontradoException extends UsernameNotFoundException {
    public UsuarioNoEncontradoException(String username) {
        super("Usuario no encontrado con el nombre de usuario -> " + username + ". ");
    }
}