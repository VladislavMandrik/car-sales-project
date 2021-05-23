package com.example.demo.ads;

import com.example.demo.classification.Classification;
import com.example.demo.classification.ClassificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsServiceImpl implements AdsService {

    private static final String EXCEPTION_MESSAGE = "Ad not found for this id :: ";

    @Autowired
    AdsRepository adsRepository;
    @Autowired
    ClassificationsRepository classificationsRepository;

    @Override
    public Page<Ad> findAllAdsByClassification(Long classificationId, Pageable pageable) {
        return adsRepository.findAllByClassificationId(classificationId, pageable);
    }

    @Override
    public Ad findAdByIdAndClassificationId(Long id, Long classificationId) {
        return adsRepository.findByIdAndClassificationId(id, classificationId)
                .orElseThrow(() -> new RuntimeException(EXCEPTION_MESSAGE + id));

    }

    @Override
    public List<Ad> findAdByClassificationIdAndPriceBetween(Long classificationId, Integer lowerPrice,
                                                            Integer higherPrice) {
        return adsRepository.findByClassificationIdAndPriceBetween(classificationId, lowerPrice, higherPrice);
    }

    @Override
    public List<Ad> findAdByClassificationIdAndYearIn(Long classificationId, List<String> year) {
        return adsRepository.findByClassificationIdAndYearIn(classificationId, year);
    }

    @Override
    public Ad save(Long classificationId, Ad ad) {
        Classification classification = classificationsRepository.findById(classificationId)
                .orElseThrow(() -> new RuntimeException(EXCEPTION_MESSAGE + classificationId));
        ad.setClassification(classification);
        return adsRepository.save(ad);
    }

    @Override
    public Ad update(Long classificationId, Long id, Ad ad) {
        Ad adInDb = adsRepository.findByIdAndClassificationId(id, classificationId).orElseThrow(() ->
                new RuntimeException(EXCEPTION_MESSAGE + id));
        adInDb.setCarName(ad.getCarName());
        adInDb.setPrice(ad.getPrice());
        adInDb.setYear(ad.getYear());
        adInDb.setDescription(ad.getDescription());
        System.out.println(adInDb);
        return adsRepository.save(adInDb);
    }

    @Override
    public void delete(Long classificationId, Long id) {
        Ad ad = adsRepository.findByIdAndClassificationId(id, classificationId)
                .orElseThrow(() -> new RuntimeException(EXCEPTION_MESSAGE + id));
        adsRepository.delete(ad);
    }
}
