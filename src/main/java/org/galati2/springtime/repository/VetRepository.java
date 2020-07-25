package org.galati2.springtime.repository;
import org.galati2.springtime.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface VetRepository  extends CrudRepository<Vet, Integer> {
    Optional<Vet> findByFirstName(String firstName);
    Iterable<Vet> findById(int id);
}
