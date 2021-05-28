package com.example.demo.classification;

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
class ClassificationsServiceImplTest {

    @Mock
    private ClassificationsRepository classificationsRepository;

    @InjectMocks
    ClassificationsServiceImpl classificationsService;

    private static Classification expectedClassification;

    @BeforeEach
    void setUp() {
        expectedClassification = createClassification();
    }

    private static final Long CLASSIFICATION_ID = 1L;
    private static final String APPOITMENT = "Passenger cars";

    private static Classification createClassification() {
        Classification classification = new Classification();
        classification.setId(CLASSIFICATION_ID);
        classification.setAppoitment(APPOITMENT);

        return classification;
    }

    @Test
    void findClassificationById() {

        when(classificationsRepository.findById(CLASSIFICATION_ID))
                .thenReturn(Optional.of(expectedClassification));

        classificationsService.findClassificationById(CLASSIFICATION_ID);

        assertEquals(CLASSIFICATION_ID, expectedClassification.getId());
        assertEquals(APPOITMENT, expectedClassification.getAppoitment());
    }

}