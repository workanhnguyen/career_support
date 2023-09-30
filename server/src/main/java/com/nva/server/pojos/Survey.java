package com.nva.server.pojos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "surveys")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @Lob
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

//    @ManyToMany(mappedBy = "surveys", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonBackReference
//    private Set<User> users;
}
