package io.chechi.auto.service;

import io.chechi.auto.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll ();

    CategoryDto addCategory (CategoryDto request);

    void deleteCategory (Integer id);
}
