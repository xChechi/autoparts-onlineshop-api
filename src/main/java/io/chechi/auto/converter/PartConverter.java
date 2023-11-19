package io.chechi.auto.converter;

import io.chechi.auto.dto.ModelDto;
import io.chechi.auto.dto.PartDto;
import io.chechi.auto.dto.PartRequest;
import io.chechi.auto.entity.Category;
import io.chechi.auto.entity.Make;
import io.chechi.auto.entity.Model;
import io.chechi.auto.entity.Part;
import io.chechi.auto.exception.CategoryNotFoundException;
import io.chechi.auto.repository.CategoryRepository;
import io.chechi.auto.repository.MakeRepository;
import io.chechi.auto.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class PartConverter {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;
    private final ModelRepository modelRepository;
    private final ModelConverter modelConverter;
    private final MakeRepository makeRepository;

    public Part addPart (PartRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new CategoryNotFoundException("Not Found")); // <--------------------

        //System.out.println(request.getCompatibleModels());

        return Part.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .category(category)
                //.compatibleModels(request.getCompatibleModels())
                .build();
    }


    public PartDto toResponse (Part part) {
    /*
        List<ModelDto> modelDtos = new ArrayList<>();

        // Convert each Model in compatibleModels to ModelDto
        for (Model model : part.getCompatibleModels()) {
            ModelDto modelDto = modelConverter.toResponse(model);
            modelDtos.add(modelDto);
        }

     */

        return PartDto.builder()
                .id(part.getId())
                .name(part.getName())
                .description(part.getDescription())
                .price(part.getPrice())
                .category(categoryConverter.toResponse(part.getCategory()))
                //.compatibleModels(modelDtos)
                .build();
    }
}
