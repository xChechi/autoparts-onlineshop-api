package io.chechi.auto.converter;

import io.chechi.auto.dto.MakeDto;
import io.chechi.auto.entity.Make;
import io.chechi.auto.entity.Model;
import io.chechi.auto.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MakeConverter {

    private final ModelRepository modelRepository;

    public Make addMake (MakeDto dto) {

        return Make.builder()
                .name(dto.getName())
                .build();
    }

    public MakeDto toResponse (Make make) {

        List<Model> modelList = modelRepository.findByMake(make);
        List<String> modelNames = modelList.stream()
                .map(Model::getName)
                .collect(Collectors.toList());

        return MakeDto.builder()
                .id(make.getId())
                .name(make.getName())
                .modelNames(modelNames)
                .build();
    }
}
