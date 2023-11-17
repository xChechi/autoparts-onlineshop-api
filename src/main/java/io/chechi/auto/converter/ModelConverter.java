package io.chechi.auto.converter;

import io.chechi.auto.dto.ModelDto;
import io.chechi.auto.entity.Make;
import io.chechi.auto.entity.Model;
import io.chechi.auto.repository.MakeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ModelConverter {

    private final MakeRepository makeRepository;

    public Model addModel (ModelDto dto) {

        return Model.builder()
                .name(dto.getName())
                .make(dto.getMake())
                .build();
    }

    public ModelDto toResponse (Model model) {

        return ModelDto.builder()
                .id(model.getId())
                .name(model.getName())
                .make(model.getMake())
                .build();
    }
}
