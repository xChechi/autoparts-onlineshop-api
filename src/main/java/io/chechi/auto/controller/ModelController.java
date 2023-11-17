package io.chechi.auto.controller;

import io.chechi.auto.dto.ModelDto;
import io.chechi.auto.dto.ModelUpdateDto;
import io.chechi.auto.service.ModelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/models")
public class ModelController {

    private final ModelService modelService;

    @GetMapping
    public ResponseEntity<List<ModelDto>> findAll (@RequestParam(value = "make", required = false) String makeName) {
        if (makeName != null && !makeName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(modelService.findByMakeName(makeName));
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body(modelService.findAll());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelDto> findById (@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(modelService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ModelDto> addModel (@RequestBody @Valid ModelDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(modelService.addModel(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelDto> updateModel (@PathVariable Integer id, @RequestBody @Valid ModelUpdateDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(modelService.updateModel(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable Integer id) {
        modelService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
