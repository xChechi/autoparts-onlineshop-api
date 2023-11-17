package io.chechi.auto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.chechi.auto.entity.Make;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelDto {

    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String name;

    @JsonIgnore
    private MakeDto make;

    private String makeName;
}
