package com.example.demo.classification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1")
public class ClassificationsController {

    private final ClassificationsService service;
    private final ClassificationMapper classificationMapper;

    @GetMapping("/classifications")
    public ResponseEntity<Page<ClassificationDTO>> getAllClassification(
            @RequestParam(required = false) String appointment,
            @PageableDefault(sort = "id", size = 3) Pageable pageable) {
        Page<Classification> classificationsPage = service.findAll(appointment, pageable);
        return ResponseEntity.ok(classificationsPage.map(classificationMapper::toClassificationDTO));
    }

    @GetMapping("/classifications/{id}")
    public ResponseEntity<ClassificationDTO> getClassificationById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(classificationMapper.toClassificationDTO
                (service.findClassificationById(id)));
    }

    @PostMapping("/classifications")
    public ResponseEntity<ClassificationDTO> createClassification
            (@RequestBody ClassificationDTO classificationDTO) {
        Classification saved = service.save(classificationMapper.toClassification(classificationDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(classificationMapper.toClassificationDTO(saved));
    }

    @PutMapping("/classifications/{id}")
    public ResponseEntity<Classification> updateClassification(@PathVariable Long id,
                                                               @RequestBody Classification classification) {
        return ResponseEntity.ok(service.update(id, classification));
    }

    @DeleteMapping("/classifications/{id}")
    public ResponseEntity<?> deleteClassification(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
