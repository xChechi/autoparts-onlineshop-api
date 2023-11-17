package io.chechi.auto.dto;

import io.chechi.auto.entity.Category;
import io.chechi.auto.entity.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PartDto {

    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String description;

    @NotNull
    private Double price;

    private Category category;

    private Set<Model> compatibleModels;
}
