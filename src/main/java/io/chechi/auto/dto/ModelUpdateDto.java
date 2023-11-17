package io.chechi.auto.dto;

import io.chechi.auto.entity.Make;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelUpdateDto {

    @NotBlank
    @Size(min = 2)
    private String name;

    @NotBlank
    @Size(min = 2)
    private MakeDto make;
}
