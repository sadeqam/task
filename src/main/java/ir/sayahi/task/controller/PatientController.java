package ir.sayahi.task.controller;

import ir.sayahi.task.repository.entities.Patient;
import ir.sayahi.task.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping
    @PreAuthorize("hasAuthority('select')")
    public List<Patient> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('select')")
    public Patient find(@PathVariable UUID id){
        return service.find(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('insert')")
    public void insert(@Valid @RequestBody Patient patient){
        service.insert(patient);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('change')")
    public void change(@Valid @RequestBody Patient patient){
        service.change(patient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('remove')")
    public void remove(@PathVariable UUID id){
        service.remove(id);
    }

}
