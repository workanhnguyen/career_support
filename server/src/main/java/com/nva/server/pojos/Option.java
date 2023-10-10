package com.nva.server.pojos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @NotBlank(message = "Không được bỏ trống")
    @Column(length = Integer.MAX_VALUE)
    private String content;

    @ManyToOne
    private Question question;

    private Date createdAt;

    private Date updatedAt;

}
