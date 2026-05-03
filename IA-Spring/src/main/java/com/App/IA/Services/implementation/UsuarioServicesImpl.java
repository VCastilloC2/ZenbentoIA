package com.App.IA.Services.implementation;

import com.App.IA.Entity.Dto.Usuario.Request.CreateUsuarioRequest;
import com.App.IA.Entity.Dto.Usuario.Response.UsuarioRespose;
import com.App.IA.Entity.Usuario;
import com.App.IA.Exception.UsuarioNoEncontradoException;
import com.App.IA.Repository.UsuarioRepository;
import com.App.IA.Services.Interfaces.UsuarioServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServicesImpl implements UsuarioServices, UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * @return
     */
    @Override
    public List<Usuario> getUsuarioByAll() {
        return usuarioRepository.findAll();
    }

    /**
     * @param usuario
     * @return
     */
    @Override
    public UsuarioRespose createUsuario(CreateUsuarioRequest usuario) {

        // Verificamos para ver si existe este username
        String username = usuario.username();
        if (usuarioRepository.existsByUsername(username)) {
            System.out.println("El usuario: " + username + " ya está registrado ... ");
            throw new RuntimeException("El usuario ya existe");
        }

        //Creamos el usuario
        Usuario user = Usuario.builder()
                .nombres(usuario.nombres())
                .apellidos(usuario.apellidos())
                .username(usuario.username())
                .password(passwordEncoder.encode(usuario.password()))
                .rol(usuario.rol())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .build();

        usuarioRepository.save(user);

        return new UsuarioRespose("El usuario: "+user.getUsername()+" se ha registrado correctamente ...");
    }


    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsuarioNoEncontradoException(username)
                );
    }

}