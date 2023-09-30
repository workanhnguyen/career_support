package com.nva.server.pojos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "scores")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Major major;

    @ManyToOne(cascade = CascadeType.ALL)
    private Year year;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "scores_combinations", joinColumns = {
            @JoinColumn(name = "score_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "combination_id", referencedColumnName = "id")
    })
    @JsonManagedReference
    private Set<Combination> combinations;

    @NotNull
    private double score;

    private String note;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;
}
