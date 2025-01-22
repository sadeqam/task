package ir.sayahi.task.controller;

import ir.sayahi.task.repository.entities.Doctor;
import ir.sayahi.task.service.MatchService;
import ir.sayahi.task.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/match", produces = MediaType.APPLICATION_JSON_VALUE)
public class MatchController {

    @Autowired
    private MatchService service;

    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}/basedOn/all")
    @PreAuthorize("hasAuthority('select')")
    public List<Doctor> matchBasedOnAll(@PathVariable UUID id){
        var patient = patientService.find(id);
        return service.match(patient.getPreferredLocation(), patient.getMedicalCondition(), true);
    }

    @GetMapping("/{id}/basedOn/locationAndSpecialization")
    @PreAuthorize("hasAuthority('select')")
    public List<Doctor> matchBasedOnLocationAndSpecialization(@PathVariable UUID id){
        var patient = patientService.find(id);
        return service.match(patient.getPreferredLocation(), patient.getMedicalCondition());
    }

    @GetMapping("/{id}/basedOn/specialization")
    @PreAuthorize("hasAuthority('select')")
    public List<Doctor> matchBasedOnSpecialization(@PathVariable UUID id){
        var patient = patientService.find(id);
        return service.match(patient.getMedicalCondition());
    }

}
