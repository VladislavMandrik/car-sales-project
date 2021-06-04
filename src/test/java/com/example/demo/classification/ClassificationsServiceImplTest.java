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
    private static final Boolean DELETED = false;
    private static final String APPOINTMENT = "Passenger cars";

    private static Classification createClassification() {
        Classification classification = new Classification();
        classification.setId(CLASSIFICATION_ID);
        classification.setDeleted(DELETED);
        classification.setAppointment(APPOINTMENT);

        return classification;
    }

    @Test
    void findClassificationById() {

        when(classificationsRepository.findById(CLASSIFICATION_ID))
                .thenReturn(Optional.of(expectedClassification));

        Classification resultClassification = classificationsService.findClassificationById(CLASSIFICATION_ID);

        assertEquals(expectedClassification.getId(), resultClassification.getId());
        assertEquals(expectedClassification.getDeleted(), resultClassification.getDeleted());
        assertEquals(expectedClassification.getAppointment(), resultClassification.getAppointment());
    }

}