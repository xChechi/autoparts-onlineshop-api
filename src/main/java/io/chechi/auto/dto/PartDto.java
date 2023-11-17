package io.chechi.auto.dto;

import io.chechi.auto.entity.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartDto {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String description;

    private List<Model> modelList;
}
