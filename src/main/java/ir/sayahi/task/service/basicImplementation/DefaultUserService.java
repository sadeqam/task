package ir.sayahi.task.service.basicImplementation;

import ir.sayahi.task.repository.UserRepository;
import ir.sayahi.task.repository.entities.User;
import ir.sayahi.task.service.UserService;
import ir.sayahi.task.service.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByUsername(username);
        if (user.isEmpty()) throw new UsernameNotFoundException("user with username (%s) not found".formatted(username));

        return user.get();
    }

    @Override
    public User insert(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public User find(String username) throws DataNotFoundException {
        var user = repository.findByUsername(username);
        if (user.isEmpty()) throw new DataNotFoundException("user with username (%s) not found".formatted(username));

        return user.get();
    }
}
