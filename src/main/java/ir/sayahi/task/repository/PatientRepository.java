package ir.sayahi.task.repository;

import ir.sayahi.task.repository.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID>{

    Boolean existsByName(String name);
}
