package ir.sayahi.task.repository;

import ir.sayahi.task.repository.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    List<Doctor> findByLocationAndSpecializationAndAvailability(String location, String specialization, Boolean availability);
    List<Doctor> findByLocationAndSpecialization(String location, String specialization);
    List<Doctor> findBySpecialization(String specialization);
}
