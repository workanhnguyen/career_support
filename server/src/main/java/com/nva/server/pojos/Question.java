package com.nva.server.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @NotBlank(message = "Không được bỏ trống")
    @Column(length = Integer.MAX_VALUE)
    private String content;

    @ManyToOne
    private Survey survey;

    private Date createdAt;

    private Date updatedAt;

//    @JsonIgnore
//    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    private Set<Option> options = new HashSet<>();

    @Transient
    @JsonIgnore
    private String listOptions;

    @ManyToOne
    private Holland holland;
}
