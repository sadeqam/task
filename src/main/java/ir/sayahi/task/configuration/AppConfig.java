package ir.sayahi.task.configuration;

import ir.sayahi.task.repository.entities.*;
import ir.sayahi.task.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner runner(PatientService patientService, DoctorService doctorService, UserService userService, RoleService roleService, AuthorityService authorityService){
        return args -> {

            if (patientService.isExists("sadeq rezaei")) return;

            patientService.insert(new Patient("sadeq rezaei", "general surgery", "isfahan"));
            patientService.insert(new Patient("abas sayahi", "orthopaedic surgery", "tehran"));

            doctorService.insert(new Doctor("ali jafarian", "general surgery", "tehran", true));
            doctorService.insert(new Doctor("bijan soltanzadeh", "general surgery", "tehran", true));
            doctorService.insert(new Doctor("abdollah zandi", "general surgery", "tehran", true));
            doctorService.insert(new Doctor("masomeh safaee", "general surgery", "isfahan", false));
            doctorService.insert(new Doctor("mojtaba ahmadzade", "general surgery", "isfahan", false));
            doctorService.insert(new Doctor("amir behzadi", "general surgery", "isfahan", false));
            doctorService.insert(new Doctor("farzad meriykh bayat", "orthopaedic surgery", "tehran", true));
            doctorService.insert(new Doctor("ahamdreza mirblock", "orthopaedic surgery", "tehran", true));
            doctorService.insert(new Doctor("majid mohsenei kabir", "orthopaedic surgery", "tehran", true));


            var select = authorityService.insert(new Authority("select"));
            var insert = authorityService.insert(new Authority("insert"));
            var change = authorityService.insert(new Authority("change"));
            var remove = authorityService.insert(new Authority("remove"));

            var admin = roleService.insert(new Role("admin", Set.of(select, insert, change, remove)));
            var user = roleService.insert(new Role("user", Set.of(select)));

            userService.insert(new User("admin", "admin", Set.of(admin, user)));
            userService.insert(new User("user", "user", Set.of(user)));

        };
    }
}
