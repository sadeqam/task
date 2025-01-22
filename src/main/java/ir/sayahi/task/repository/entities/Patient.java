package ir.sayahi.task.repository.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "patient_id")
    private UUID id;

    @NotBlank(message = "Patient name can't be blank")
    @Column(name = "patient_name")
    private String name;

    @NotBlank(message = "Patient medical condition can't be blank")
    @Column(name = "patient_medical_condition")
    private String medicalCondition;

    @NotBlank(message = "Patient preferred location can't be blank")
    @Column(name = "patient_preferred_location")
    private String preferredLocation;

    public Patient(){
    }

    public Patient(String name, String medicalCondition, String preferredLocation) {
        this.name = name;
        this.medicalCondition = medicalCondition;
        this.preferredLocation = preferredLocation;
    }

    public Patient(UUID id, String name, String medicalCondition, String preferredLocation) {
        this.id = id;
        this.name = name;
        this.medicalCondition = medicalCondition;
        this.preferredLocation = preferredLocation;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;
        return Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Patient{ id=%s, name='%s', medicalCondition='%s', preferredLocation='%s' }".formatted(id, name, medicalCondition, preferredLocation);
    }
}
