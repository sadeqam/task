package ir.sayahi.task.service.basicImplementation;

import ir.sayahi.task.repository.DoctorRepository;
import ir.sayahi.task.repository.entities.Doctor;
import ir.sayahi.task.service.MatchService;
import ir.sayahi.task.service.exceptions.NoMatchFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleMatchService implements MatchService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> match(String location, String specialization, Boolean availability) throws NoMatchFoundException {
        var list = doctorRepository.findByLocationAndSpecializationAndAvailability(
                location,
                specialization,
                availability
        );
        if (list.isEmpty())
            throw new NoMatchFoundException("No match is found based on : %s, %s, availability = %b".formatted(location, specialization, availability));

        return list;
    }

    @Override
    public List<Doctor> match(String location, String specialization) throws NoMatchFoundException {
        var list = doctorRepository.findByLocationAndSpecialization(location, specialization);
        if (list.isEmpty())
            throw new NoMatchFoundException("No match is found based on : %s, %s".formatted(location, specialization));

        return list;
    }

    @Override
    public List<Doctor> match(String specialization) throws NoMatchFoundException {
        var list = doctorRepository.findBySpecialization(specialization);
        if (list.isEmpty())
            throw new NoMatchFoundException("No match is found based on : %s".formatted(specialization));

        return list;
    }

}
