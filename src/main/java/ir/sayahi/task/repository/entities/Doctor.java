package ir.sayahi.task.repository.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "doctor_id")
    private UUID id;

    @NotBlank(message = "Doctor name can't be blank")
    @Column(name = "doctor_name")
    private String name;

    @NotBlank(message = "Doctor specialization can't be blank")
    @Column(name = "doctor_specialization")
    private String specialization;

    @NotBlank(message = "Doctor location can't be blank")
    @Column(name = "doctor_location")
    private String location;

    @Column(name = "doctor_availability")
    private Boolean availability;

    public Doctor() {
    }

    public Doctor(String name, String specialization, String location, Boolean availability) {
        this.name = name;
        this.specialization = specialization;
        this.location = location;
        this.availability = availability;
    }

    public Doctor(UUID id, String name, String specialization, String location, Boolean availability) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.location = location;
        this.availability = availability;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;
        return Objects.equals(id, doctor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Doctor{ id=%s, name='%s', specialization='%s', location='%s', availability=%b }".formatted(id, name, specialization, location, availability);
    }
}
