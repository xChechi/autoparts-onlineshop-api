package io.chechi.auto.converter;

import io.chechi.auto.dto.MakeDto;
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
    private final MakeConverter makeConverter;

    public Model addModel (ModelDto dto) {

        Make make = makeRepository.findByName(dto.getMake().getName());

        return Model.builder()
                .name(dto.getName())
                .make(make)
                .build();
    }

    public ModelDto toResponse (Model model) {

        return ModelDto.builder()
                .id(model.getId())
                .name(model.getName())
                //.make(makeConverter.toResponse(model.getMake()))
                .makeName(model.getMake().getName())
                .build();
    }
}
