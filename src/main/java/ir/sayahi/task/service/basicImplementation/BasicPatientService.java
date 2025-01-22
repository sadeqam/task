package ir.sayahi.task.service.basicImplementation;

import ir.sayahi.task.repository.PatientRepository;
import ir.sayahi.task.repository.entities.Patient;
import ir.sayahi.task.service.PatientService;
import ir.sayahi.task.service.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BasicPatientService implements PatientService {

    @Autowired
    private PatientRepository repository;

    @Override
    public List<Patient> findAll() {
        return repository.findAll();
    }

    @Override
    public Patient find(UUID id) {
        var patient = repository.findById(id);
        if (patient.isEmpty())
            throw new DataNotFoundException("Patient with id (%s) not found".formatted(id));
        return patient.get();
    }

    @Override
    public Boolean isExists(String name) {
        return repository.existsByName(name);
    }

    @Override
    public void insert(Patient patient) {
        repository.save(patient);
    }

    @Override
    public void change(Patient patient) throws DataNotFoundException {
        if (repository.findById(patient.getId()).isEmpty())
            throw new DataNotFoundException("Patient with id (%s) not found".formatted(patient.getId()));
        repository.save(patient);
    }

    @Override
    public void remove(UUID id) {
        repository.deleteById(id);
    }
}
