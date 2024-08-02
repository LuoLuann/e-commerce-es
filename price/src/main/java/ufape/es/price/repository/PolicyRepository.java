package ufape.es.price.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufape.es.price.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
