package ir.sayahi.task.service;


import ir.sayahi.task.repository.entities.User;
import ir.sayahi.task.service.exceptions.DataNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User insert(User user);
    User find(String username) throws DataNotFoundException;

}
