package com.example.demo.classification;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClassificationsServiceImpl implements ClassificationsService {

    private static final String EXCEPTION_MESSAGE = "Classification not found for this id :: ";

    @Autowired
    ClassificationsRepository repository;

    @Override
    public Page<Classification> findAll(String appointment, Pageable pageable) {
        if (appointment == null) {
            return repository.findAll(pageable);
        } else {
            return repository.findAllByAppointment(appointment, pageable);
        }
    }

    @Override
    public Classification findClassificationById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException
                (EXCEPTION_MESSAGE + id));
    }

    @Override
    public Classification save(Classification classification) {
        return repository.save(classification);
    }

    @Override
    public Classification update(Long id, Classification classification) {
        Classification classificationInDb = repository.findById(id).orElseThrow(() ->
                new RuntimeException(EXCEPTION_MESSAGE + id));
        classificationInDb.setAppointment(classification.getAppointment());
        return repository.save(classificationInDb);
    }

    @Override
    public void delete(Long id) {
        Classification classification = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(EXCEPTION_MESSAGE + id));
        repository.delete(classification);
    }
}
