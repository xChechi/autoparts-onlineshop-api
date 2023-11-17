package io.chechi.auto.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.chechi.auto.dto.MakeDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Models")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "make_id")
    @JsonBackReference
    private Make make;
}
