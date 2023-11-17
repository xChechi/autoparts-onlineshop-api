package io.chechi.auto.converter;

import io.chechi.auto.dto.PartDto;
import io.chechi.auto.entity.Part;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PartConverter {

    public Part addPart (PartDto request) {

        return Part.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .category(request.getCategory())
                .compatibleModels(request.getCompatibleModels())
                .build();
    }

    public PartDto toResponse (Part part) {

        return PartDto.builder()
                .id(part.getId())
                .name(part.getName())
                .description(part.getDescription())
                .price(part.getPrice())
                .category(part.getCategory())
                .compatibleModels(part.getCompatibleModels())
                .build();
    }
}
