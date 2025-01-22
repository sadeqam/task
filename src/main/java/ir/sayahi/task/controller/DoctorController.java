package ir.sayahi.task.controller;

import ir.sayahi.task.repository.entities.Doctor;
import ir.sayahi.task.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/doctors", produces = MediaType.APPLICATION_JSON_VALUE)
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping
    @PreAuthorize("hasAuthority('select')")
    public List<Doctor> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('select')")
    public Doctor find(@PathVariable UUID id){
        return service.find(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('insert')")
    public void insert(@Valid @RequestBody Doctor doctor){
        service.insert(doctor);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('change')")
    public void change(@Valid @RequestBody Doctor doctor){
        service.change(doctor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('remove')")
    public void remove(@PathVariable UUID id){
        service.remove(id);
    }

}
