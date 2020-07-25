package org.galati2.springtime.repository;
import org.galati2.springtime.model.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface SpecialityRepository  extends CrudRepository<Speciality, Integer> {
    Iterable<Speciality> findByName(String name);
    Iterable<Speciality> findByNameAndId(String name, int id);
    Iterable<Speciality> findByNameOrId(String name, int id);

}
