package org.galati2.springtime.repository;
import org.galati2.springtime.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface OwnerRepository extends  CrudRepository<Owner, Integer> {
    //PagingAndSortingRepository pentru paginare si sortare
    Iterable<Owner> findByFirstNameContaining(String name);
    Iterable<Owner> findByLastNameContaining(String name);
    Iterable<Owner> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName);
    Iterable<Owner> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
