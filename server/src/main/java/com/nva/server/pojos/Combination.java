package com.nva.server.pojos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "combination")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Combination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "combinations_subjects", joinColumns = {
            @JoinColumn(name = "group_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "subject_id", referencedColumnName = "id")
    })
    @JsonManagedReference
    private Set<Subject> subjects;

//    @ManyToMany(mappedBy = "combinations", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonBackReference
//    private Set<Major> majors;
}
