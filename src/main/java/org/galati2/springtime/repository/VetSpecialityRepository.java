package org.galati2.springtime.repository;

import org.galati2.springtime.model.VetSpeciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component

public interface VetSpecialityRepository  extends CrudRepository<VetSpeciality, Integer> {
    Optional<VetSpeciality> findByVetId (int id);
    Iterable<VetSpeciality> findById(int id);
}
