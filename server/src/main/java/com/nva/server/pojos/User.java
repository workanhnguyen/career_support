package com.nva.server.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nva.server.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Column(unique = true)
    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

    private String avatar;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private Boolean locked = false;
    private Boolean enabled = false;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Transient
    @JsonIgnore
    private MultipartFile avatarFile;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "users_surveys", joinColumns = {
//            @JoinColumn(name = "user_id", referencedColumnName = "id")
//    }, inverseJoinColumns = {
//            @JoinColumn(name = "survey_id", referencedColumnName = "id")
//    })
//    @JsonManagedReference
//    private Set<Survey> surveys;

    // ------------------- UserDetails implements -----------------------
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
