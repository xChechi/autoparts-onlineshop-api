package io.chechi.auto.service.impl;

import io.chechi.auto.converter.CategoryConverter;
import io.chechi.auto.dto.CategoryDto;
import io.chechi.auto.entity.Category;
import io.chechi.auto.repository.CategoryRepository;
import io.chechi.auto.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> responses = new ArrayList<>();

        for (Category c : categoryList) {
            CategoryDto response = categoryConverter.toResponse(c);
            responses.add(response);
        }

        return responses;
    }

    @Override
    public CategoryDto addCategory(CategoryDto request) {
        Category category = categoryConverter.addCategory(request);
        Category savedCategory = categoryRepository.save(category);

        return categoryConverter.toResponse(savedCategory);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
