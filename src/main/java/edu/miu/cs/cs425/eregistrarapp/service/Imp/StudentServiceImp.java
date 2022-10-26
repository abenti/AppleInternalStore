package edu.miu.cs.cs425.eregistrarapp.service.Imp;

import edu.miu.cs.cs425.eregistrarapp.dto.StudentRequest;
import edu.miu.cs.cs425.eregistrarapp.exception.StudentNotFoundException;
import edu.miu.cs.cs425.eregistrarapp.model.Student;
import edu.miu.cs.cs425.eregistrarapp.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrarapp.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PageRanges;
import java.util.List;
import java.util.Optional;

@Service

@AllArgsConstructor()
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper = new ModelMapper();


//    @Override
//    public Page<Student> getAllStudents2( int pageNo) {
////        return  studentRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
//        return  studentRepository.findAll(PageRequest.of(pageNo, 3, Sort.Direction.ASC, "firstName"));
//    }
    @Override
    public List<Student> getAllStudents( ) {
        return  studentRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
//        return  studentRepository.findAll(PageRequest.of(pageNo, 3, Sort.Direction.ASC, "firstName"));
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student addStudent(StudentRequest studentRequest) {
        Student s = modelMapper.map(studentRequest, Student.class);
        studentRepository.save(s);
        return s;
    }

    @Override
    public Student editStudent(Integer studentId, Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student findStudentById(Integer studentId)  {
        return null;
    }

    @Override
    public Student findStudentByName(String name) {
        return studentRepository.getStudentByStudentName(name)
                .orElseThrow();
    }
// working on this
    @Override
    public Student getStudentById(Integer studentId) throws StudentNotFoundException {
        return studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(
                String.format("Student with ID: %d, is not found", studentId)));

    }

    @Override
    public Student updateStudent(StudentRequest  studentRequest, Integer studentId) {
        // implement update using builder
        /* Student updatedStudent = Student.build(
                studentId,
                studentRequest.getFirstName(),
                studentRequest.getMiddleName(),
                studentRequest.getLastName(),
                studentRequest.getCgpa(),
                studentRequest.getEnrollmentDate(),
                studentRequest.getIsInternational());*/
        Student student = modelMapper.map(studentRequest, Student.class);
        studentRepository.save(student);
        return student;
//        Student s =  studentRepository.findStudentByStudentId(student.getStudentId());
//        s = student;
    }

    @Override
    public List<Student> searchStudent(String searchString) {
        return studentRepository.findAllByFirstNameContainingOrLastNameContainingOrMiddleNameContaining(
                searchString, searchString,searchString
        );
    }
}
