package io.chechi.auto.dto;

import io.chechi.auto.entity.Model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MakeDto {

    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String name;

    private List<Model> modelList;
}
