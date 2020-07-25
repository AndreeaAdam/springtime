package org.galati2.springtime.service;


import org.galati2.springtime.model.Owner;
import org.galati2.springtime.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> findByFirstNameAndLastName() {
        List<Owner> results = new ArrayList<>();
        Iterable<Owner> owners = ownerRepository.findAll();

//        for (Owner owner : owners) {
//            results.add(owner);
//        }

        //pt fiecare element results din List apeleaza metoda add(owner)
        // pentru fiecare result
        owners.forEach(results::add);
        return results;

    }

    public List<Owner> getOwnersByLastName(String lastName) {
        List<Owner> results = new ArrayList<>();
        if (lastName == null) {
            return findByFirstNameAndLastName();
        }
        Iterable<Owner> owners = ownerRepository.findByLastNameContaining(lastName);
        owners.forEach(results::add);
        return results;
    }

    public List<Owner> getOwnersByFirstName(String firstName) {
        List<Owner> results = new ArrayList<>();
        if (firstName == null) {
            return findByFirstNameAndLastName();
        }
        Iterable<Owner> owners = ownerRepository.findByFirstNameContaining(firstName);
        owners.forEach(results::add);
        return results;
    }

    public Owner getOwnerById(int id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public List<Owner> findByFirstNameAndLastName(String firstName, String lastName) {
        if (lastName == null) {
            return getOwnersByFirstName(firstName);
        }
        if (firstName == null) {
            return getOwnersByLastName(lastName);
        }
        List<Owner> results = new ArrayList<>();
        Iterable<Owner> owners = ownerRepository.findByFirstNameContainingAndLastNameContaining(firstName, lastName);

        owners.forEach(results::add);
        return results;
    }

    public List<Owner> findByFirstNameOrLastName(String firstName, String lastName) {
        if (lastName == null) {
            return getOwnersByFirstName(firstName);
        }
        if (firstName == null) {
            return getOwnersByLastName(lastName);
        }
        List<Owner> results = new ArrayList<>();
        Iterable<Owner> owners = ownerRepository.findByFirstNameContainingOrLastNameContaining(firstName, lastName);
        owners.forEach(results::add);
        return results;
    }

    public Owner saveOwner(Owner owner) {
        if (owner.getId() > 0 && !ownerRepository.existsById(owner.getId())) {
            return null;
        }
        return ownerRepository.save(owner);
    }

    public void deleteOwner(int id) {
        ownerRepository.deleteById(id);
    }
//    public Iterable<Owner> testOwnerService() {
//        Iterable<Owner> owners = ownerRepository.findAll();
//        for (Owner o : owners) {
//            System.out.println(o.getFirstName() + " " + o.getLastName());
//        }
//        return owners;
//    }


}
