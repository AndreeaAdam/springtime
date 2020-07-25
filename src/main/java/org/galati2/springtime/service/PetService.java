package org.galati2.springtime.service;

import org.galati2.springtime.model.Pet;
import org.galati2.springtime.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public List<Pet> getPets() {
        List<Pet> results = new ArrayList<>();
        Iterable<Pet> pets = petRepository.findAll();
        pets.forEach(results::add);
        return results;
    }

    public Pet getPet(int id) {
        return petRepository.findById(id).orElse(null);
    }

    public List<Pet> findPetByName(String name) {
        List<Pet> results = new ArrayList<>();
//        if (name == null) {
//          return  getPets();
//        }
        Iterable<Pet> pets = petRepository.findByName(name);
        pets.forEach(results::add);
        return results;
    }

    public List<Pet> findPetByTypeId(int typeID) {
        List<Pet> results = new ArrayList<>();
//        if (typeID == 0) {
//           return getPets();
//        }
        Iterable<Pet> pets = petRepository.findByTypeId(typeID);
        pets.forEach(results::add);
        return results;
    }

    public List<Pet> findByNameAndTypeId(String name, int typeId) {
//        if (typeId == 0) {
//            return findPetByName(name);
//        }
//        if (name == null) {
//            return findPetByTypeId(typeId);
//        }
        List<Pet> results = new ArrayList<>();
        Iterable<Pet> pets = petRepository.findByNameAndTypeId(name, typeId);
        pets.forEach(results::add);
        return results;
    }

    public List<Pet> findByNameOrTypeId(String name, int typeId) {
//        if (name == null) {
//           return findPetByTypeId(typeId);
//        }
//        if (typeId == 0) {
//            return findPetByName(name);
//        }
        List<Pet> results = new ArrayList<>();
        Iterable<Pet> pets = petRepository.findByNameOrTypeId(name, typeId);
        pets.forEach(results::add);
        return results;
    }


//    public void testPetService() {
//        Iterable<Pet> pets = petRepository.findAll();
//        for (Pet pet: pets) {
//            System.out.println(pet.getName() + " " + pet.getBirthDate());
//        }
}

