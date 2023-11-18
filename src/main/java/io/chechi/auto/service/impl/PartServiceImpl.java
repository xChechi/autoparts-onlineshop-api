package io.chechi.auto.service.impl;

import io.chechi.auto.converter.PartConverter;
import io.chechi.auto.dto.PartDto;
import io.chechi.auto.dto.PartRequest;
import io.chechi.auto.dto.PartUpdateDto;
import io.chechi.auto.entity.Make;
import io.chechi.auto.entity.Model;
import io.chechi.auto.entity.Part;
import io.chechi.auto.exception.PartNotFoundException;
import io.chechi.auto.repository.MakeRepository;
import io.chechi.auto.repository.ModelRepository;
import io.chechi.auto.repository.PartRepository;
import io.chechi.auto.service.PartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final PartConverter partConverter;
    private final ModelRepository modelRepository;
    private final MakeRepository makeRepository;

    @Override
    public List<PartDto> findAll() {
        List<Part> partList = partRepository.findAll();
        List<PartDto> responses = new ArrayList<>();

        for (Part p : partList) {
            PartDto response = partConverter.toResponse(p);
            responses.add(response);
        }
        return responses;
    }

    @Override
    public PartDto findById(Integer id) {
        Part part = partRepository.findById(id).orElseThrow(() -> new PartNotFoundException("Part not exist in database"));
        return partConverter.toResponse(part);
    }

    @Override
    public PartDto addPart(PartRequest request) {

        Set<Model> models = request.getCompatibleModels();

        for (Model model : models) {
            Make make = model.getMake();
            String modelName = model.getName();
            String makeName = make.getName();

            // Check if the model exists
            Model existingModel = modelRepository.findByNameAndMakeName(modelName, makeName);

            if (existingModel == null) {
                // Model doesn't exist, create a new one along with the associated make
                Make existingMake = makeRepository.findByName(makeName);

                if (existingMake == null) {
                    existingMake = makeRepository.save(make);
                }

                // Create a new model associated with the make
                Model newModel = Model.builder()
                        .name(modelName)
                        .make(existingMake)
                        .build();

                // Save the new model
                modelRepository.save(newModel);
            }

            // Further logic using existingModel if needed
            // Add the model to the part or perform other operations as required
        }

        // Proceed with saving the Part after processing the models
        Part part = partConverter.addPart(request);
        Part savedPart = partRepository.save(part);

        return partConverter.toResponse(savedPart);
    }

    @Override
    public PartDto updatePart(Integer id, PartUpdateDto request) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<PartDto> searchByCategoryAndModel(Integer categoryId) {
        return null;
    }

    @Override
    public List<PartDto> searchByName(String name) {
        return null;
    }
}
