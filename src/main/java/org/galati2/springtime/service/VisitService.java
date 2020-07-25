package org.galati2.springtime.service;

import org.galati2.springtime.model.Visit;
import org.galati2.springtime.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class VisitService {
    @Autowired
    private VisitRepository visitRepository;

    public List<Visit> getVisits() {
        List<Visit> resuts = new ArrayList<>();
        Iterable<Visit> visits = visitRepository.findAll();
        visits.forEach(resuts::add);
        return resuts;
    }
//    public void testVisitService() {
//        Iterable<Visit> visits = visitRepository.findAll();
//        for (Visit visit: visits) {
//            System.out.println(visit.getDescription() + " " + visit.getVisitDate());
//        }
//
//    }
}
