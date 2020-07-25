package org.galati2.springtime.service;

import org.galati2.springtime.model.Type;
import org.galati2.springtime.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getTypes() {
        List<Type> results = new ArrayList<>();
        Iterable<Type> types = typeRepository.findAll();
        types.forEach(results::add);
        return results;
    }
//    public void testTypeService() {
//        Iterable<Type> types = typeRepository.findAll();
//        for (Type type: types) {
//            System.out.println(type.getName());
//        }
//
//    }
}
