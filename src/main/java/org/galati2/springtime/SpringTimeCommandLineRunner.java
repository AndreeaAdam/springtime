package org.galati2.springtime;

import org.galati2.springtime.controllers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class SpringTimeCommandLineRunner implements CommandLineRunner {
    @Autowired
    private OwnerController ownerController;
    @Autowired
    private PetController petController;
    @Autowired
    private SpecialityController specialityController;
    @Autowired
    private TypeController typeController;
    @Autowired
    private VetController vetController;
    @Autowired
    private VetSpecialityController vetSpecialityController;
    @Autowired
    private VisitController visitController;

    @Override
    public void run(String... args) throws Exception {
        //ownerController.readOwners();
//        petController.readPets();
//        specialityController.readSpecialities();
//        typeController.readTypes();
//        vetController.readVets();
//        vetSpecialityController.readVetSpecialities();
//        visitController.readServices();
    }

}

