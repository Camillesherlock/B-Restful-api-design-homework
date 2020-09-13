package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Students;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.StudentsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudentsController {
private StudentsService studentsService;
public StudentsController(StudentsService studentsService){
    this.studentsService = studentsService;
}

@PostMapping(path="/addition")
    public void addStudents(@RequestBody Students students){
    studentsService.addStudent(students);
}

}
