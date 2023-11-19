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
import java.util.HashSet;
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
        partRepository.deleteById(id);
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
