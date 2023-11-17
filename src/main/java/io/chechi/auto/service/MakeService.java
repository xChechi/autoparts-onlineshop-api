package io.chechi.auto.service;

import io.chechi.auto.dto.MakeDto;
import io.chechi.auto.dto.MakeUpdateDto;

import java.util.List;

public interface MakeService {

    List<MakeDto> findAll ();

    MakeDto findById (Integer id);

    MakeDto addMake (MakeDto dto);

    MakeDto updateMake (Integer id, MakeUpdateDto dto);

    void deleteById (Integer id);
}
