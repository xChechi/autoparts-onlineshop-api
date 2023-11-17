package io.chechi.auto.service;

import io.chechi.auto.dto.ModelDto;
import io.chechi.auto.dto.ModelUpdateDto;
import io.chechi.auto.entity.Model;

import java.util.List;

public interface ModelService {

    List<ModelDto> findAll (Integer id);

    ModelDto findById (Integer id);

    ModelDto addModel (ModelDto dto);

    ModelDto updateModel (Integer id, ModelUpdateDto dto);

    void deleteById (Integer id);
}
