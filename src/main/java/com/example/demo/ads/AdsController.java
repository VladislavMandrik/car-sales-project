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

    @GetMapping("/ads")
    public ResponseEntity<Page<Ad>> getAllAd(
            @PageableDefault(sort = "id", size = 3) Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllAd(pageable));
    }

    @GetMapping("/ads/{id}")
    public ResponseEntity<Ad> getAdById(@PathVariable(value = "id") Long id) {
//        Book book = service.findBookById(id);
        return ResponseEntity.ok().body(service.findAdById(id));
    }

    @GetMapping("/ads/{price}")
    public ResponseEntity<Ad> getBookByPrice(@PathVariable(value = "price") Integer price) {
//        Book book = service.findBookByName(name);
        return ResponseEntity.ok().body(service.findAdByPrice(price));
    }

    @PostMapping("/ads")
    public ResponseEntity<Ad> createAd(@RequestBody Ad ad) {
        return ResponseEntity.ok().body(service.save(ad));
    }

    @PutMapping("/ads/{id}")
    public ResponseEntity<Ad> updateAd(
            @PathVariable Long id,
            @RequestBody Ad ad) {
//        Book updatedBook = service.update(id, book);
        return ResponseEntity.ok(service.update(id, ad));
    }

    @DeleteMapping("/ads/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
