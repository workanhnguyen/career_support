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
@Table(name = "hollands")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Holland {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String abbreviation;

    @NotNull
    private String title;

    @Lob
    private String description;

    @Lob
    private String suitableCareer;

    private String image;

    @Lob
    private String strength;

    @Lob
    private String weakness;

    private Date createdAt;

    private Date updatedAt;

}
