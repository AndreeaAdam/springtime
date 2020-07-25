package org.galati2.springtime.controllers;

import org.galati2.springtime.model.Owner;
import org.galati2.springtime.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OwnerController {
    @Autowired //sa o injecteze, instantiat automat
    private OwnerService ownerService;

    @GetMapping("/owners")
    public String readOwners(
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName,
            Model userInterfaceModel // view  model
    ) {
        List<Owner> owners = ownerService.findByFirstNameOrLastName(firstName, lastName);
        userInterfaceModel.addAttribute("owners", owners);
        return "ownersList";
    }

//    @GetMapping("/owners/add")
//    public String addOwner(Model model) {
//        model.addAttribute("owner", new Owner());
//        return "addOwner";
//    }

    @PostMapping("/owners/{id}")
    public String changeOwner(@PathVariable int id, @ModelAttribute("owner") Owner owner, Model model) {
        owner.setId(id);
        ownerService.saveOwner(owner);
        model.addAttribute("owner", ownerService.findByFirstNameAndLastName());
        return "ownersList";
    }

    @PutMapping("/owners/{id}")
    public ResponseEntity<Owner> addOwner(@PathVariable int id, @RequestBody Owner owner) {
        owner.setId(id);
        Owner result = ownerService.saveOwner(owner);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/owners/{id}")
    public ResponseEntity<Owner> deleteOwner(@PathVariable int id) {
        ownerService.deleteOwner(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/owners/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable int id) {
        Owner result = ownerService.getOwnerById(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


//    @GetMapping("/owners/{firstName}")
//    public List<Owner> getOwners(@PathVariable String firstName) {
//        List<Owner> result = ownerService.getOwnersByFirstName(firstName);
//        return result;
//    }
}
