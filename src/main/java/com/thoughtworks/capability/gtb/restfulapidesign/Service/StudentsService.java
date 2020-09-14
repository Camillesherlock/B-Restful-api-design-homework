package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Students;
import com.thoughtworks.capability.gtb.restfulapidesign.Domain.StudentsGroup;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentsService {
    static public List<StudentsGroup> studentsGroups;
    static public int[]groupNumber = new int[6];
    static public List<Students> maleStudents = new ArrayList<>();
    static public List<Students> femaleStudents = new ArrayList<>();
    public List<Students> studentsList = studentsListInit();
    public List<Students> originStudentsList = studentsListInit();
    private StudentsRepository studentsRepository;

    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }
    static List<String> teamName = new ArrayList<String>() {
        {
            add("Team 1");
            add("Team 2");
            add("Team 3");
            add("Team 4");
            add("Team 5");
            add("Team 6");
        }
    };
    public List<Students> studentsListInit() {
        List<Students> studentsList = new ArrayList<Students>();
        Students students1 = new Students();
        students1.builder().name("xiaohong").id(1).gender(Students.Gender.MALE).note("good students")
                .build();
        studentsList.add(students1);
        if(students1.getGender()== Students.Gender.MALE)
        {
            maleStudents.add(students1);
        }
        else {
            femaleStudents.add(students1);
        }
        return studentsList;
    }

    public void initGroup(){
        studentsGroups = new ArrayList<>();
    }

    public List<Students> getStudentsList(){
        return originStudentsList;
    }

    public List<Students> addStudent(Students students) {
        if (students != null) {
            studentsList.add(students);
            originStudentsList.add(students);
            if(students.getGender()== Students.Gender.MALE){
                maleStudents.add(students);
            }
            else {
                femaleStudents.add(students);
            }
        }
        return studentsList;
    }

    public List<Students> deleteStudent(Students students) {
        int id = students.getId();
        studentsList.remove(students);
        originStudentsList.remove(students);
        if(students.getGender()== Students.Gender.MALE){
            maleStudents.remove(students);
        } else{
            femaleStudents.remove(students);
        }
        return studentsList;
    }

    public Students getOneStudent(String name) {
        Students byName = studentsRepository.findByName(name);
        return byName;
    }

    public void updateStudentsMessage(Students students) {
        int id = students.getId();
        Students students1 = studentsList.get(id);
        Collections.replaceAll(studentsList, students1, students);
        Collections.replaceAll(originStudentsList, students1, students);
        if(students.getGender()== Students.Gender.MALE){
            Collections.replaceAll(maleStudents,students1,students);
        }else{
            Collections.replaceAll(femaleStudents,students1,students);
        }
    }
    public List<Students> getMaleStudents(){
        return maleStudents;
    }

    public List<Students> getFemaleStudents(){
        return femaleStudents;
    }

    public int[] getGroupNumber(int numbers){
        int preGroup = numbers/6;
        int restToAdd = numbers%6;
        for(int i = 0; i < 6; i++){
            if(restToAdd==0){
                groupNumber[i] = preGroup;
            }
            else{
                groupNumber[i] = preGroup + 1;
                restToAdd--;
            }
        }
        return groupNumber;
    }
    public List<StudentsGroup> getStudentsGroups(){
        initGroup();
        Collections.shuffle(studentsList);
        for(int i = 0; i< 6; i++){
            List<Students> tmp = new ArrayList<>();
            for(int j = 0; j < groupNumber[i]; j++){
                tmp.add(studentsList.get(i*groupNumber[i]+j));
            }
            StudentsGroup eachGroup = new StudentsGroup();
            eachGroup.builder().groupId(i).groupName(teamName.get(i))
                    .groupNote("good team").students(tmp);
            studentsGroups.add(eachGroup);
        }
        return studentsGroups;
    }

    public void changeTeamName(String originName, String updateName) throws Exception {
        if(Collections.frequency(teamName,updateName)>0){
            throw new Exception("Conflict Name");
        } else {
            teamName.set(teamName.indexOf(originName),updateName);
        }
    }
}
