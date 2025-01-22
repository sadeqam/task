package ir.sayahi.task.service.basicImplementation;

import ir.sayahi.task.repository.RoleRepository;
import ir.sayahi.task.repository.entities.Role;
import ir.sayahi.task.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultRoleService implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role insert(Role role) {
        return repository.save(role);
    }

}
