package org.galati2.springtime.controllers;

import org.galati2.springtime.model.Pet;
import org.galati2.springtime.model.Speciality;
import org.galati2.springtime.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecialityController {
    @Autowired
    private SpecialityService specialityService;
    @GetMapping("/specialities")
            public List<Speciality> getSpecialities(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "id", required = false) int id){
        List<Speciality> specialities = specialityService.getByNameAndId(name, id);
        return specialities;
    }
    @GetMapping("/specialities/{id}")
        public ResponseEntity<Speciality> getSpeciality(@PathVariable int id) {
            Speciality result = specialityService.getSpecialityByID(id);
            if (result == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
