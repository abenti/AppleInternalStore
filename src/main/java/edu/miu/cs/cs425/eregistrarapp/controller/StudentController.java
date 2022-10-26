package edu.miu.cs.cs425.eregistrarapp.controller;

import edu.miu.cs.cs425.eregistrarapp.dto.StudentRequest;
import edu.miu.cs.cs425.eregistrarapp.exception.StudentNotFoundException;
import edu.miu.cs.cs425.eregistrarapp.model.Student;
import edu.miu.cs.cs425.eregistrarapp.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = {"/eregistrar/api/student"})
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping(value = {"/list"}) ///eregistrar/api/student/list
    public ResponseEntity<List<Student>> listStudent() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    // if you have bi-directional relation

    @GetMapping(value = {"search/{studentId}"}) // /eregistrar/api/student/1
    public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) throws StudentNotFoundException {
        var student = studentService.getStudentById(studentId);
        return ResponseEntity.ok( student);
    }
    @PostMapping(value = {"/new"})
    public ResponseEntity<Student> addNewStudent(@Valid @RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.addStudent(studentRequest), HttpStatus.CREATED);
    }
    @PutMapping(value = {"/update/{studentId}"})
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody StudentRequest studentRequest,
                                                @PathVariable Integer studentId)  {
        return new ResponseEntity<>(studentService.updateStudent(studentRequest, studentId),HttpStatus.OK);
    }
    @DeleteMapping(value = {"/delete/{studentId}"})
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(value = {"/find/{nameStart}"})
    public ResponseEntity<Student>searchStudentByName(@PathVariable String nameStart) {
        return ResponseEntity.ok(studentService.findStudentByName(nameStart));
    }


}
