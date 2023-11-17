package io.chechi.auto.controller;

import io.chechi.auto.dto.MakeDto;
import io.chechi.auto.dto.MakeUpdateDto;
import io.chechi.auto.service.MakeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/makes")
public class MakeController {

    private final MakeService makeService;

    @GetMapping
    public ResponseEntity<List<MakeDto>> findAll () {
        return ResponseEntity.status(HttpStatus.OK).body(makeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MakeDto> findById (@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(makeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MakeDto> addMake (@RequestBody @Valid MakeDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(makeService.addMake(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MakeDto> updateMake (@PathVariable Integer id, @RequestBody @Valid MakeUpdateDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(makeService.updateMake(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable Integer id) {
        makeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
