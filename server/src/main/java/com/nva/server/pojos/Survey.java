package com.nva.server.pojos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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

    @NotBlank(message = "Không được bỏ trống")
    @Size(max = 255, message = "Tiêu đề quá dài")
    private String title;

    @Lob
    @NotBlank(message = "Không được bỏ trống")
    @Column(length = Integer.MAX_VALUE)
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

//    @JsonIgnore
//    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    private Set<Question> questions = new HashSet<>();
}
