package com.debarz.recipeapp.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank
    @Size(min=3, max=20)
    private String username;

    @Column(nullable = false)
    @NotBlank
    @Size(min=3, max=254)
    private String lastName;

//    @Column(nullable = false)
//    @NotBlank
    @Size(min=3, max=254)
    private String name; //Todo:--?

    @Column(nullable = false)
    @NotBlank
    @Size(min=3, max=254)
    private String password;

    @Transient
    private String repeatPassword;//Todo:--?

    @Column(nullable = false)
    @NotBlank
    @Size(min=3, max=254)
    private String email;

    private String phone;

    private String avatar;

//    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
