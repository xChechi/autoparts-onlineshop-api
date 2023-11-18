package io.chechi.auto.converter;

import io.chechi.auto.dto.CategoryDto;
import io.chechi.auto.entity.Category;
import io.chechi.auto.entity.Part;
import io.chechi.auto.repository.PartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CategoryConverter {

    private final PartRepository partRepository;

    public Category addCategory(CategoryDto request) {

        return Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }

    public CategoryDto toResponse (Category category) {

        //List<Part> partList = partRepository.findByCategory(category);

        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                //.parts(partList)
                .build();
    }
}
