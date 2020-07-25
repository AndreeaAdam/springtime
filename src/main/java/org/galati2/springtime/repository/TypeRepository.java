package org.galati2.springtime.repository;
import org.galati2.springtime.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface TypeRepository  extends CrudRepository<Type, Integer> {
    Iterable<Type> findById(int id);
    Optional<Type> findByName(String name);
}
