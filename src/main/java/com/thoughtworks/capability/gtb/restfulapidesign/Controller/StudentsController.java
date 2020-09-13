package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Students;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.StudentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentsController {
private StudentsService studentsService;
public StudentsController(StudentsService studentsService){
    this.studentsService = studentsService;
}

@PostMapping(path="/addition")
    public ResponseEntity<List<Students>> addStudents(@RequestBody Students student){
    studentsService.addStudent(student);
    return ResponseEntity.status(HttpStatus.OK).body(studentsService.studentsList);
}

@DeleteMapping(path="/deletion")
    public ResponseEntity<List<Students>> deleteStudents(@RequestBody Students student){
    studentsService.deleteStudent(student);
    return ResponseEntity.status(HttpStatus.OK).body(studentsService.studentsList);
}

@GetMapping(path="")

}
