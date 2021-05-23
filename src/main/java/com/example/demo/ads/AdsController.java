package com.example.demo.ads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        return ResponseEntity.ok().body(service.findAdByIdAndClassificationId(id, classificationId));
    }

    @GetMapping("/classifications/{classificationId}/ads-price")
    public ResponseEntity<List<Ad>> getAdByPriceBetween
            (@PathVariable(value = "classificationId") Long classificationId,
             @RequestParam(value = "lowerPrice") Integer lowerPrice,
             @RequestParam(value = "higherPrice") Integer higherPrice) {
        return ResponseEntity.ok().body(service.findAdByClassificationIdAndPriceBetween(classificationId,
                lowerPrice, higherPrice));
    }

    @GetMapping("/classifications/{classificationId}/ads-year")
    public ResponseEntity<List<Ad>> getAdByPriceIn
            (@PathVariable(value = "classificationId") Long classificationId,
             @RequestParam(value = "year") List<String> year) {
        return ResponseEntity.ok().body(service.findAdByClassificationIdAndYearIn(classificationId, year));
    }

    @PostMapping("/classifications/{classificationId}/ads")
    public ResponseEntity<Ad> createAd(@PathVariable Long classificationId,
                                       @Valid
                                       @RequestBody Ad ad) {
        return ResponseEntity.ok().body(service.save(classificationId, ad));
    }

    @PutMapping("/classifications/{classificationId}/ads/{id}")
    public ResponseEntity<Ad> updateAd(@PathVariable(value = "classificationId") Long classificationId,
                                       @PathVariable(value = "id") Long id,
                                       @Valid
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
