package org.galati2.springtime.controllers;

import org.galati2.springtime.model.Type;
import org.galati2.springtime.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("/types")
    public List<Type> readTypes(){
        List<Type> types = typeService.getTypes();
        return types;
    }
}
