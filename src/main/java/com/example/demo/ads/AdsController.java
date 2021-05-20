package com.example.demo.ads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AdsController {

    @Autowired
    private AdsService service;

    @GetMapping("/classifications/{classificationId}/ads")
    public ResponseEntity<Page<Ad>> getAllAd(@PathVariable Long classificationId,
                                             @PageableDefault(sort = "id", size = 3) Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllAdsByClassification(classificationId, pageable));
    }

    @GetMapping("/classifications/{classificationId}/ads/{id}")
    public ResponseEntity<Ad> getAdById(@PathVariable(value = "classificationId") Long classificationId,
                                        @PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(service.findAdByIdByClassification(id, classificationId));
    }

//    @GetMapping("/classifications/{classificationId}/ads/{carName}")
//    public ResponseEntity<Ad> getAdByCarName(@PathVariable(value = "classificationId") Long classificationId,
//                                             @PathVariable(value = "carName") String carName) {
//        return ResponseEntity.ok().body(service.findAdByCarNameByClassification(carName, classificationId));
//    }

    @PostMapping("/classifications/{classificationId}/ads")
    public ResponseEntity<Ad> createAd(@PathVariable Long classificationId,
                                       @RequestBody Ad ad) {
        return ResponseEntity.ok().body(service.save(classificationId, ad));
    }

    @PutMapping("/classifications/{classificationId}/ads/{id}")
    public ResponseEntity<Ad> updateAd(@PathVariable(value = "classificationId") Long classificationId,
                                       @PathVariable(value = "id") Long id,
                                       @RequestBody Ad ad) {
        return ResponseEntity.ok(service.update(classificationId, id, ad));
    }

    @DeleteMapping("/classifications/{classificationId}/ads/{id}")
    public ResponseEntity<?> deleteAd(@PathVariable(value = "classificationId") Long classificationId,
                                      @PathVariable(value = "id") Long id) {
        service.delete(classificationId, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
