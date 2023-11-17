package io.chechi.auto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private List<Model> modelList;

    private List<String> modelNames;
}
