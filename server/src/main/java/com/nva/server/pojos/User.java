package com.nva.server.pojos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
    private String firstName;

    @NotNull
    @Size(max = 40)
    private String lastName;

    @Column(unique = true)
    @Email
    @NotNull
    private String email;

    private String avatar;

    @Transient
    private MultipartFile avatarFile;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_surveys", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "survey_id", referencedColumnName = "id")
    })
    @JsonManagedReference
    private Set<Survey> surveys;
}
