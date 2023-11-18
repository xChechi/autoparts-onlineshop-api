package io.chechi.auto.service;

import io.chechi.auto.dto.PartDto;
import io.chechi.auto.dto.PartRequest;
import io.chechi.auto.dto.PartUpdateDto;

import java.util.List;

public interface PartService {

    List<PartDto> findAll ();

    PartDto findById (Integer id);

    PartDto addPart (PartRequest request);

    PartDto updatePart (Integer id, PartUpdateDto request);

    void deleteById (Integer id);

    List<PartDto> searchByCategoryAndModel (Integer categoryId); // <-------------------

    List<PartDto> searchByName (String name);  // <-------------------
}
