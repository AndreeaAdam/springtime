package org.galati2.springtime.service;

import org.galati2.springtime.model.VetSpeciality;
import org.galati2.springtime.repository.VetSpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class VetSpecialityService {
    @Autowired
    private VetSpecialityRepository vetSpecialityRepository;

    public List<VetSpeciality> getVetSpecialities() {
        List<VetSpeciality> results = new ArrayList<>();
        Iterable<VetSpeciality> vetSpecialities = vetSpecialityRepository.findAll();
        vetSpecialities.forEach(results::add);
        return results;

    }
//    public void testVetSpecialitytService() {
//        Iterable<VetSpeciality> vetSpecialities = vetSpecialityRepository.findAll();
//        for (VetSpeciality vetSpeciality: vetSpecialities) {
//            System.out.println(vetSpeciality.getSpecialityId() + " " + vetSpeciality.getVetId());
//        }
//    }
}
