package io.chechi.auto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Makes")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "make_id")
    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String name;

    @OneToMany(mappedBy = "make", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Model> modelList;
}
