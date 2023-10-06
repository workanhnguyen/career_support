package com.nva.server.pojos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "options")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @NotNull
    private String content;

    @ManyToOne
    private Question question;

    private Date createdAt;

    private Date updatedAt;

}
