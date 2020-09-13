package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Students;
import com.thoughtworks.capability.gtb.restfulapidesign.Domain.StudentsGroup;
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

@GetMapping(path="/students")
    public ResponseEntity<Students> findOneStudent(@RequestParam String name){
    Students oneStudent = studentsService.getOneStudent(name);
    return ResponseEntity.status(HttpStatus.OK).body(oneStudent);

}

@PutMapping(path="/students/operation")
    public ResponseEntity<List<Students>> changeStudentMessage(@RequestBody Students students){
    studentsService.updateStudentsMessage(students);
    return  ResponseEntity.status(HttpStatus.OK).body(studentsService.originStudentsList);
}

@GetMapping(path="group-list")
    public ResponseEntity<List<StudentsGroup>> getStudentsGroup(){
    List<StudentsGroup> studentsGroups = studentsService.getStudentsGroups();
    return ResponseEntity.status(HttpStatus.OK).body(studentsGroups);
}

@PostMapping(path="group-name")
    public ResponseEntity<List<StudentsGroup>> changeTeamName(@RequestParam String originName,
                                                              @RequestParam String updateName){
    try{ studentsService.changeTeamName(originName, updateName);
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.getStudentsGroups());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}

}
