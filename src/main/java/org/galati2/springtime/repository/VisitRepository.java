package org.galati2.springtime.repository;

import org.galati2.springtime.model.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface VisitRepository extends CrudRepository<Visit, Integer> {
    Iterable<Visit> findById(int id);
}
