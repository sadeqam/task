package ir.sayahi.task.service.basicImplementation;

import ir.sayahi.task.repository.DoctorRepository;
import ir.sayahi.task.repository.entities.Doctor;
import ir.sayahi.task.service.DoctorService;
import ir.sayahi.task.service.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BasicDoctorService implements DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Override
    public List<Doctor> findAll() {
        return repository.findAll();
    }

    @Override
    public Doctor find(UUID id) {
        var doctor = repository.findById(id);
        if (doctor.isEmpty())
            throw new DataNotFoundException("Doctor with id (%s) not found".formatted(id));
        return doctor.get();
    }

    @Override
    public void insert(Doctor doctor) {
        repository.save(doctor);
    }

    @Override
    public void change(Doctor doctor) throws DataNotFoundException {
        if (repository.findById(doctor.getId()).isEmpty())
            throw new DataNotFoundException("Doctor with id (%s) not found".formatted(doctor.getId()));
        repository.save(doctor);
    }

    @Override
    public void remove(UUID id) {
        repository.deleteById(id);
    }
}
