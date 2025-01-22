package ir.sayahi.task.service;

import ir.sayahi.task.repository.entities.Doctor;
import ir.sayahi.task.repository.entities.Patient;
import ir.sayahi.task.service.exceptions.DataNotFoundException;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    List<Patient> findAll();
    Patient find(UUID id) throws DataNotFoundException;
    Boolean isExists(String name);
    void insert(Patient patient);
    void change(Patient patient) throws DataNotFoundException;
    void remove(UUID id);


}
