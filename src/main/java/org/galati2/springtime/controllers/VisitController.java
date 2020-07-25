package org.galati2.springtime.controllers;

import org.galati2.springtime.model.Visit;
import org.galati2.springtime.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitController {
    @Autowired
    private VisitService visitService;

    @GetMapping("/visits")
    public List<Visit> readServices() {
        List<Visit> visits = visitService.getVisits();
        return visits;
    }
}
