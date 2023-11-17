package io.chechi.auto.service.impl;

import io.chechi.auto.converter.ModelConverter;
import io.chechi.auto.dto.ModelDto;
import io.chechi.auto.dto.ModelUpdateDto;
import io.chechi.auto.entity.Make;
import io.chechi.auto.entity.Model;
import io.chechi.auto.exception.ModelNotFoundException;
import io.chechi.auto.repository.ModelRepository;
import io.chechi.auto.service.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelConverter modelConverter;

    @Override
    public List<ModelDto> findAll() {
        List<Model> modelList = modelRepository.findAll();
        List<ModelDto> modelResponses = new ArrayList<>();

        for (Model m : modelList) {
            ModelDto response = modelConverter.toResponse(m);
            modelResponses.add(response);
        }
        return modelResponses;
    }

    @Override
    public ModelDto findById(Integer id) {
        Model model = modelRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Model not found in database"));
        return modelConverter.toResponse(model);
    }

    @Override
    public ModelDto addModel(ModelDto dto) {
        Model model = modelConverter.addModel(dto);
        Model savedModel = modelRepository.save(model);
        return modelConverter.toResponse(savedModel);
    }

    @Override
    public ModelDto updateModel(Integer id, ModelUpdateDto dto) {
        Model model = modelRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Model not found in database"));

        model.setName(dto.getName());
        model.setMake(dto.getMake());

        Model savedModel = modelRepository.save(model);
        return modelConverter.toResponse(savedModel);
    }

    @Override
    public void deleteById(Integer id) {
        modelRepository.deleteById(id);
    }

    @Override
    public List<ModelDto> findByMake(Make make) {
        List<Model> modelList = modelRepository.findByMake(make);
        List<ModelDto> responses = new ArrayList<>();

        for (Model m : modelList) {
            ModelDto response = modelConverter.toResponse(m);
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<ModelDto> findByMakeName(String makeName) {

        List<Model> modelList = modelRepository.findByMakeName(makeName);
        List<ModelDto> responses = new ArrayList<>();

        for (Model m : modelList) {
            ModelDto response = modelConverter.toResponse(m);
            responses.add(response);
        }
        return responses;
    }
}
