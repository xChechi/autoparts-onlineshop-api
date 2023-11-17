package io.chechi.auto.service.impl;

import io.chechi.auto.converter.MakeConverter;
import io.chechi.auto.dto.MakeDto;
import io.chechi.auto.dto.MakeUpdateDto;
import io.chechi.auto.entity.Make;
import io.chechi.auto.exception.MakeNotFoundException;
import io.chechi.auto.repository.MakeRepository;
import io.chechi.auto.service.MakeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MakeServiceImpl implements MakeService {

    private final MakeRepository makeRepository;
    private final MakeConverter makeConverter;

    @Override
    public List<MakeDto> findAll() {
        List<Make> makeList = makeRepository.findAll();
        List<MakeDto> makeResponses = new ArrayList<>();

        for (Make m : makeList) {
            MakeDto response = makeConverter.toResponse(m);
            makeResponses.add(response);
        }

        return makeResponses;
    }

    @Override
    public MakeDto findById(Integer id) {
        Make make = makeRepository.findById(id).orElseThrow(() -> new MakeNotFoundException("Make not exist in database"));
        return makeConverter.toResponse(make);
    }

    @Override
    public MakeDto addMake(MakeDto dto) {
        Make make = makeConverter.addMake(dto);
        Make savedMake = makeRepository.save(make);

        return makeConverter.toResponse(savedMake);
    }

    @Override
    public MakeDto updateMake(Integer id, MakeUpdateDto dto) {
        Make make = makeRepository.findById(id).orElseThrow(() -> new MakeNotFoundException("Make not exist in database"));
        make.setName(dto.getName());
        Make savedMake = makeRepository.save(make);
        return makeConverter.toResponse(savedMake);
    }

    @Override
    public void deleteById(Integer id) {
        makeRepository.deleteById(id);
    }
}
