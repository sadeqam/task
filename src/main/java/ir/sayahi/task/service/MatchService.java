package ir.sayahi.task.service;

import ir.sayahi.task.repository.entities.Doctor;
import ir.sayahi.task.service.exceptions.NoMatchFoundException;

import java.util.List;

public interface MatchService {

    List<Doctor> match(String location, String specialization, Boolean availability) throws NoMatchFoundException;
    List<Doctor> match(String location, String specialization) throws NoMatchFoundException;
    List<Doctor> match(String specialization) throws NoMatchFoundException;

}
