package org.galati2.springtime.controllers;

import org.galati2.springtime.model.Pet;
import org.galati2.springtime.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("/pets")
    public List<Pet> readPets(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "typeId", required = false, defaultValue = "0") int typeId
    ) {
        List<Pet> pets;
        if(name == null && typeId == 0){
            pets = petService.getPets();
        }
        else if(name == null){
            pets = petService.findPetByTypeId(typeId);
        }
        else if(typeId == 0){
            pets = petService.findPetByName(name);
        }
        else
        pets = petService.findByNameAndTypeId(name, typeId);
        return pets;
    }
    @GetMapping("/pets/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable int id) {
        Pet result = petService.getPet(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
