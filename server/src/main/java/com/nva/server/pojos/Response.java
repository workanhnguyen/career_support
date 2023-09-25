package com.nva.server.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "responses")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;

    @ManyToOne(cascade = CascadeType.ALL)
    private Option selectedOption;

    @Lob
    private String textResponse;
}
