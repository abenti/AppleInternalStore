package edu.miu.cs.cs425.eregistrarapp.service;

import edu.miu.cs.cs425.eregistrarapp.dto.StudentRequest;
import edu.miu.cs.cs425.eregistrarapp.exception.StudentNotFoundException;
import edu.miu.cs.cs425.eregistrarapp.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
//    public Page<Student> getAllStudents(int pageNo);
    public Student addStudent(Student student);
    public Student addStudent(StudentRequest studentRequest);
//    public Student addStudent(StudentRequest studentRequest);
    public Student editStudent(Integer studentId, Student student);
    public void deleteStudent(Integer studentId);
    public Student findStudentById(Integer studentId) ;
    public Student findStudentByName(String name) ;
    public Student getStudentById(Integer studentId) throws StudentNotFoundException ;
    public Student updateStudent(StudentRequest studentRequest, Integer studentId);
    public List<Student> searchStudent(String searchString);

}
