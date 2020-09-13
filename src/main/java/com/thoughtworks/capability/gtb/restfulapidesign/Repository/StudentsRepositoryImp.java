package com.thoughtworks.capability.gtb.restfulapidesign.Repository;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Students;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentsRepositoryImp implements StudentsRepository{
private final Map<String, Students> students = new HashMap<>();
    @Override
    public Students findByName(String name){
        return  students.get(name);
    }

}
