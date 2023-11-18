package io.chechi.auto.converter;

import io.chechi.auto.dto.PartDto;
import io.chechi.auto.dto.PartRequest;
import io.chechi.auto.entity.Category;
import io.chechi.auto.entity.Part;
import io.chechi.auto.exception.CategoryNotFoundException;
import io.chechi.auto.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PartConverter {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    public Part addPart (PartRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new CategoryNotFoundException("Not Found")); // <--------------------
        System.out.println(category);

        return Part.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .category(category)
                .compatibleModels(request.getCompatibleModels())
                .build();
    }

    public PartDto toResponse (Part part) {

        return PartDto.builder()
                .id(part.getId())
                .name(part.getName())
                .description(part.getDescription())
                .price(part.getPrice())
                .category(categoryConverter.toResponse(part.getCategory()))
                .compatibleModels(part.getCompatibleModels())
                .build();
    }
}
