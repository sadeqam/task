package ir.sayahi.task.service;

import ir.sayahi.task.repository.entities.Doctor;
import ir.sayahi.task.service.exceptions.DataNotFoundException;

import java.util.List;
import java.util.UUID;

public interface DoctorService {

    List<Doctor> findAll();
    Doctor find(UUID id) throws DataNotFoundException;
    void insert(Doctor doctor);
    void change(Doctor doctor) throws DataNotFoundException;
    void remove(UUID id);

}
