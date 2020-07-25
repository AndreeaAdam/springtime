package org.galati2.springtime.controllers;

import org.galati2.springtime.model.VetSpeciality;
import org.galati2.springtime.service.VetSpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VetSpecialityController {
    @Autowired
    private VetSpecialityService vetSpecialityService;
    @GetMapping("/vetspecialities")
    public List<VetSpeciality> readVetSpecialities(){
        List<VetSpeciality> vetSpecialities = vetSpecialityService.getVetSpecialities();
        return vetSpecialities;
    }
}
