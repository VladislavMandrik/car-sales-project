package com.example.demo.classification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClassificationsController {

    @Autowired
    private ClassificationsService service;

    @GetMapping("/classifications")
    public ResponseEntity<Page<Classification>> getAllClassification(
            @PageableDefault(sort = "id", size = 3) Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllClassification(pageable));
    }

    @GetMapping("/classifications/{id}")
    public ResponseEntity<Classification> getClassificationById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(service.findClassificationById(id));
    }

    @PostMapping("/classifications")
    public ResponseEntity<Classification> createClassification(@RequestBody Classification classification) {
        return ResponseEntity.ok().body(service.save(classification));
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
