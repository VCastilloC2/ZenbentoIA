package com.App.IA.Entity;

import com.App.IA.Entity.Enum.Rol;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long Id;

    @Column(length = 200, nullable = false)
    private String nombres;

    @Column(length = 200, nullable = false)
    private String apellidos;

    @Column(length = 200, nullable = false)
    private String username;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Builder.Default
    private boolean isEnabled = true;

    @Builder.Default
    private boolean accountNonExpired = true;

    @Builder.Default
    private boolean accountNonLocked = true;

    @Builder.Default
    private boolean credentialsNonExpired = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (rol == null) {
            throw new IllegalStateException("El rol del usuario no puede ser null");
        }

        return List.of(new SimpleGrantedAuthority("ROLE_" + rol.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

}