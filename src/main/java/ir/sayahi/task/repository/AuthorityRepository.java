package ir.sayahi.task.repository;

import ir.sayahi.task.repository.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
