package ir.sayahi.task.service.basicImplementation;

import ir.sayahi.task.repository.AuthorityRepository;
import ir.sayahi.task.repository.entities.Authority;
import ir.sayahi.task.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultAuthorityService implements AuthorityService {

    @Autowired
    private AuthorityRepository repository;

    @Override
    public Authority insert(Authority authority) {
        return repository.save(authority);
    }
}
