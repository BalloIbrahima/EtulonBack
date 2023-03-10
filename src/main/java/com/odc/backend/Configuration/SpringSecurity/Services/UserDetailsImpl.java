package com.odc.backend.Configuration.SpringSecurity.Services;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odc.backend.Models.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetailsImpl implements UserDetails{
    
    private Long id;
    private String nom;
    private String prenom;
    private String username;
    private String telephone;
    private String email;
    private String photo;
    private Long point;
    private Long niveau;
    private String Pays;
    private String ville;
    private String adresse;
    @JsonIgnore
    private String password;
    private Date dateSouscription;

    private Collection<? extends GrantedAuthority> authorities;


    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getName().name()))
            .collect(Collectors.toList());
    
        return new UserDetailsImpl(
            user.getId(), 
            user.getNom(),
            user.getPrenom(),
            user.getUsername(), 
            user.getTelephone(),
            user.getEmail(),
            user.getPhoto(),
            user.getPoint(),
            user.getNiveau(),
            user.getPays(),
            user.getVille(),
            user.getAdresse(),
            user.getPassword(), 
            user.getDateSouscription(),
            authorities);
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
        return true;
        if (o == null || getClass() != o.getClass())
        return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
