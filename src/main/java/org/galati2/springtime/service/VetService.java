package org.galati2.springtime.service;

import org.galati2.springtime.model.Vet;
import org.galati2.springtime.repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VetService {
    @Autowired
    private VetRepository vetRepository;

    public List<Vet> getVets() {
        List<Vet> results = new ArrayList<>();
        Iterable<Vet> vets = vetRepository.findAll();
        vets.forEach(results::add);
        return results;
    }
//    public void testVetService() {
//        Iterable<Vet> vets = vetRepository.findAll();
//        for (Vet vet: vets) {
//            System.out.println(vet.getFirstName() + " " + vet.getLastName());
//        }
//    }
}
