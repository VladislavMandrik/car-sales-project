package com.example.demo.classification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClassificationsServiceImpl implements ClassificationsService {

    private static final String EXCEPTION_MESSAGE = "Classification not found for this id :: ";

    @Autowired
    ClassificationsRepository repository;

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Classification save(Classification classification) {
        return repository.save(classification);
    }

    @Override
    public Classification update(Long id, Classification classification) {
        Classification classificationInDb = repository.findById(id).orElseThrow(() ->
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

        return repository.save(classificationInDb);
    }

    @Override
    public Page<Classification> findAllClassification(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Classification findClassificationById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException
                (EXCEPTION_MESSAGE + id));
    }

//    @Override
//    public Ad findAdByPrice(Integer price) {
//        return repository.findByPrice(price)
//                .orElseThrow(() -> new RuntimeException(EXCEPTION_MESSAGE + price));
//    }
}
