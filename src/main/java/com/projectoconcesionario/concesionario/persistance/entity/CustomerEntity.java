package com.projectoconcesionario.concesionario.persistance.entity;

import com.projectoconcesionario.concesionario.persistance.entity.enums.Role;
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
@Table(name = "clientes")
public class CustomerEntity implements UserDetails {
    @Id
    private String dni;
    @Column(name = "nombre_completo")
    private String fullName;
    private String email;
    @Column(name = "numero_telefono")
    private String phoneNumber;
    @Column(name = "contrasenia")
    private String password;
    @Column(name = "activo")
    private Integer active;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "customerEntity",cascade = CascadeType.ALL)
    private List<PurchaseEntity> purchaseEntityList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
