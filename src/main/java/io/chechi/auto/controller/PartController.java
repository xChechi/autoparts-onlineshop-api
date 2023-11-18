package io.chechi.auto.controller;

import io.chechi.auto.dto.PartDto;
import io.chechi.auto.dto.PartRequest;
import io.chechi.auto.service.PartService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/parts")
public class PartController {

    private final PartService partService;

    @GetMapping
    public ResponseEntity<List<PartDto>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(partService.findAll());
    }

    @PostMapping
    public ResponseEntity<PartDto> addPart (@RequestBody @Valid PartRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(partService.addPart(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePart (@PathVariable Integer id) {
        partService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
