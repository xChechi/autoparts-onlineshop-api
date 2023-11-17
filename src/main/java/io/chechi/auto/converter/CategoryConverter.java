package io.chechi.auto.converter;

import io.chechi.auto.dto.CategoryDto;
import io.chechi.auto.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryConverter {

    public Category addCategory(CategoryDto request) {

        return Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }

    public CategoryDto toResponse (Category response) {

        return CategoryDto.builder()
                .id(response.getId())
                .name(response.getName())
                .description(response.getDescription())
                .parts(response.getParts())
                .build();
    }
}
