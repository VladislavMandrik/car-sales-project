package com.example.demo.ads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdsServiceImpl implements AdsService {

    private static final String EXCEPTION_MESSAGE = "Ad not found for this id :: ";

    @Autowired
    AdsRepository repository;

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Ad save(Ad ad) {
        return repository.save(ad);
    }

    @Override
    public Ad update(Long id, Ad ad) {
        Ad adInDb = repository.findById(id).orElseThrow(() ->
                new RuntimeException(EXCEPTION_MESSAGE + id));

//        if (ad.getCar() != null) {
//            adInDb.setCar(ad.getCar());
//        }
//
//        if (ad.getPrice() != null) {
//            adInDb.setPrice(ad.getPrice());
//        }
//
//        if (ad.getYear() != null) {
//            adInDb.setYear(ad.getYear());
//        }
//
//        if (ad.getDescription() != null) {
//            adInDb.setDescription(ad.getDescription());
//        }

        return repository.save(adInDb);
    }

    @Override
    public Page<Ad> findAllAd(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Ad findAdById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException
                (EXCEPTION_MESSAGE + id));
    }

    @Override
    public Ad findAdByPrice(Integer price) {
        return repository.findByPrice(price)
                .orElseThrow(() -> new RuntimeException(EXCEPTION_MESSAGE + price));
    }
}
