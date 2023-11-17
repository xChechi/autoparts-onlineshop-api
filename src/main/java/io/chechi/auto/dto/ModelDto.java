package io.chechi.auto.dto;

import io.chechi.auto.entity.Make;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelDto {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String name;

    private Make make;
}
