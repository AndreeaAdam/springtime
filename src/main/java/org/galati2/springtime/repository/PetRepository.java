package org.galati2.springtime.repository;

import org.galati2.springtime.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PetRepository extends CrudRepository<Pet, Integer> {
    Iterable<Pet> findByName(String name);
    Iterable<Pet> findByNameAndTypeId(String name, int typeId);
    Iterable<Pet> findByNameOrTypeId(String name, int typeId);
    Iterable<Pet> findByTypeId(int typeId);
}
