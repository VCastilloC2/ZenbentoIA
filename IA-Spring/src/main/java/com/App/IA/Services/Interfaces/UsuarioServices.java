package com.App.IA.Services.Interfaces;

import com.App.IA.Entity.Dto.Usuario.Request.CreateUsuarioRequest;
import com.App.IA.Entity.Dto.Usuario.Response.UsuarioRespose;
import com.App.IA.Entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioServices {

    // Obtener el usuario por Id
    Optional<Usuario> getUsuarioById(Long id);

    // Obtener todos los usuarios
    List<Usuario> getUsuarioByAll();

    // Crear usuario
    UsuarioRespose createUsuario(CreateUsuarioRequest usuario);

}