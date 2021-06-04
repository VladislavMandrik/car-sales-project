package com.example.demo.ads;

import com.example.demo.classification.ClassificationsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdsServiceImplTest {

    @Mock
    private AdsRepository adsRepository;

    @Mock
    private ClassificationsRepository classificationsRepository;

    @InjectMocks
    AdsServiceImpl adsService;

    private static Ad expectedAd;

    @BeforeEach
    void setUp() {
        expectedAd = createAd();
    }

    private static final Long CLASSIFICATION_ID = 1L;
    private static final Long AD_ID = 2L;
    private static final String CAR_NAME = "Mitsubishi Carisma";
    private static final Integer PRICE = 1900;
    private static final String YEAR = "2001";
    private static final String DESCRIPTION = "Very good car";

    private static Ad createAd() {
        Ad ad = new Ad();
        ad.setId(AD_ID);
        ad.setCarName(CAR_NAME);
        ad.setPrice(PRICE);
        ad.setYear(YEAR);
        ad.setDescription(DESCRIPTION);

        return ad;
    }

    @Test
    void findAdByIdAndClassificationId() {

        when(adsRepository.findByIdAndClassificationId(AD_ID, CLASSIFICATION_ID))
                .thenReturn(Optional.of(expectedAd));

        Ad resultAd = adsService.findAdByIdAndClassificationId(AD_ID, CLASSIFICATION_ID);

        assertEquals(expectedAd.getId(), resultAd.getId());
        assertEquals(expectedAd.getCarName(), resultAd.getCarName());
        assertEquals(expectedAd.getPrice(), resultAd.getPrice());
        assertEquals(expectedAd.getYear(), resultAd.getYear());
        assertEquals(expectedAd.getDescription(), resultAd.getDescription());
    }
}