package org.galati2.springtime.service;

import org.galati2.springtime.model.Speciality;
import org.galati2.springtime.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SpecialityService {
    @Autowired
    private SpecialityRepository specialityRepository;

    public List<Speciality> getSpecialities() {
        List<Speciality> results = new ArrayList<>();
        Iterable<Speciality> specialities = specialityRepository.findAll();
        specialities.forEach(results::add);
        return results;

    }
    public Speciality getSpecialityByID(int id) {
        return specialityRepository.findById(id).orElse(null);
    }
    public List<Speciality> getSpecialityByName(String name){
        if (name == null){
           return getSpecialities();
        }
        List<Speciality> results = new ArrayList<>();
        Iterable<Speciality> specialities = specialityRepository.findByName(name);
        specialities.forEach(results::add);
        return results;
    }
    public List<Speciality> getByNameOrId(String name, int id){
        if (name == null){
            return (List<Speciality>) getSpecialityByID(id);
        }
        if (id == 0){
            return getSpecialityByName(name);
        }
        List<Speciality> results = new ArrayList<>();
        Iterable<Speciality> specialities = specialityRepository.findByNameOrId(name, id);
        specialities.forEach(results::add);
        return results;
    }
    public List<Speciality> getByNameAndId(String name, int id){
        if (name == null){
            return (List<Speciality>) getSpecialityByID(id);
        }
        if (id == 0){
            return getSpecialityByName(name);
        }

        List<Speciality> results = new ArrayList<>();
        Iterable<Speciality> specialities = specialityRepository.findByNameAndId(name, id);
        specialities.forEach(results::add);
        return results;
    }
//    public void testSpecialityService() {
//        Iterable<Speciality> specialities = specialityRepository.findAll();
//        for (Speciality speciality: specialities) {
//            System.out.println(speciality.getName());
//        }
//    }
}
