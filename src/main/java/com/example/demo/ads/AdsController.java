package com.example.demo.ads;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AdsController {

    private final AdsService service;
    private final AdMapper adMapper;

    @GetMapping("classifications/{classificationId}/ads")
    public ResponseEntity<Page<AdDTO>> getAllAd(@PathVariable Long classificationId,
                                                @RequestParam(required = false) String carName,
                                                @RequestParam(required = false) Integer price,
                                                @PageableDefault(sort = "id", size = 3) Pageable pageable) {
        Page<Ad> adPage = service.findAll(classificationId, carName, price, pageable);
        return ResponseEntity.ok(adPage.map(adMapper::toAdDTO));
    }

    @GetMapping("/classifications/{classificationId}/ads/{id}")
    public ResponseEntity<AdDTO> getAdById(@PathVariable(value = "classificationId") Long classificationId,
                                           @PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(adMapper.toAdDTO(service.findAdByIdAndClassificationId
                (id, classificationId)));
    }

    @PostMapping("/classifications/{classificationId}/ads")
    public ResponseEntity<AdDTO> createAd(@PathVariable Long classificationId,
                                          @Valid
                                          @RequestBody AdDTO adDTO) {
        Ad ad = adMapper.toAd(adDTO);
        Ad saved = service.save(classificationId, ad);
        return ResponseEntity.status(HttpStatus.CREATED).body(adMapper.toAdDTO(saved));
    }

    @PutMapping("/classifications/{classificationId}/ads/{id}")
    public ResponseEntity<AdDTO> updateAd(@PathVariable(value = "classificationId") Long classificationId,
                                          @PathVariable(value = "id") Long id,
                                          @Valid
                                          @RequestBody AdDTO adDTO) {
        Ad ad = adMapper.toAd(adDTO);
        Ad updated = service.update(classificationId, id, ad);
        return ResponseEntity.ok(adMapper.toAdDTO(updated));
    }

    @DeleteMapping("/classifications/{classificationId}/ads/{id}")
    public ResponseEntity<?> deleteAd(@PathVariable(value = "classificationId") Long classificationId,
                                      @PathVariable(value = "id") Long id) {
        service.delete(classificationId, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
