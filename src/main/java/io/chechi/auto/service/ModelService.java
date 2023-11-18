package io.chechi.auto.service;

import io.chechi.auto.dto.ModelDto;
import io.chechi.auto.dto.ModelRequest;
import io.chechi.auto.dto.ModelUpdateDto;
import io.chechi.auto.entity.Make;
import io.chechi.auto.entity.Model;

import java.util.List;

public interface ModelService {

    List<ModelDto> findAll ();

    ModelDto findById (Integer id);

    ModelDto addModel (ModelRequest dto);

    ModelDto updateModel (Integer id, ModelUpdateDto dto);

    void deleteById (Integer id);

    List<ModelDto> findByMake (Make make);

    List<ModelDto> findByMakeName(String makeName);
}
