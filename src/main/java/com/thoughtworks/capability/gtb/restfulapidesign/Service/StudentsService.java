package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Students;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.StudentsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsService {
   private List<Students> studentsList = studentsListInit();
//    private StudentsRepository studentsRepository;
//    public StudentsService(StudentsRepository studentsRepository){
//        this.studentsRepository = studentsRepository;
//    }
    public List<Students> studentsListInit(){
        List<Students> studentsList = new ArrayList<Students>();
        Students students1 = new Students();
        students1.builder().name("xiaohong").id(1).gender("male").note("good students")
                .build();
        studentsList.add(students1);
        return studentsList;
    }
    public ResponseEntity addStudent(Students students){
        if(students != null){
            studentsList.add(students);
        }
    return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
