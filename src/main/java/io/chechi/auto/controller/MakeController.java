package io.chechi.auto.controller;

import io.chechi.auto.dto.MakeDto;
import io.chechi.auto.dto.MakeUpdateDto;
import io.chechi.auto.service.MakeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/makes")
public class MakeController {

    private final MakeService makeService;

    public ResponseEntity<List<MakeDto>> findAll () {
        return ResponseEntity.status(HttpStatus.FOUND).body(makeService.findAll());
    }

    public ResponseEntity<MakeDto> findById (Integer id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(makeService.findById(id));
    }

    public ResponseEntity<MakeDto> addMake (@RequestBody @Valid MakeDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(makeService.addMake(dto));
    }

    public ResponseEntity<MakeDto> updateMake (Integer id, @RequestBody @Valid MakeUpdateDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(makeService.updateMake(id, dto));
    }

    public ResponseEntity<Void> deleteById (Integer id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
