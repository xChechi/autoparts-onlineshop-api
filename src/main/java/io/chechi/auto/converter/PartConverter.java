package io.chechi.auto.converter;

import io.chechi.auto.dto.PartDto;
import io.chechi.auto.entity.Category;
import io.chechi.auto.entity.Part;
import io.chechi.auto.repository.ModelRepository;
import io.chechi.auto.repository.PartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PartConverter {

    public Part addPart (Category category, PartDto dto) {

        return Part.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .category(category)
                .modelList(dto.getModelList())
                .build();
    }
}
