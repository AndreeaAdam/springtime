package org.galati2.springtime.controllers;

import org.galati2.springtime.model.Vet;
import org.galati2.springtime.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VetController {
    @Autowired
    private VetService vetService;
    @GetMapping("/vets")
    public List<Vet> readVets(){
        List<Vet> vets = vetService.getVets();
        return vets;
    }
}
