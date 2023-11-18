package io.chechi.auto.controller;

import io.chechi.auto.dto.PartDto;
import io.chechi.auto.dto.PartRequest;
import io.chechi.auto.service.PartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/parts")
public class PartController {

    private final PartService partService;

    @PostMapping
    public ResponseEntity<PartDto> addPart (PartRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(partService.addPart(request));
    }

}
