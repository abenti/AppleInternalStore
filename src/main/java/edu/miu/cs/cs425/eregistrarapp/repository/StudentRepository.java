package edu.miu.cs.cs425.eregistrarapp.repository;

import edu.miu.cs.cs425.eregistrarapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
//    public Student findStudentsByFirstName(String firstName);
//    public Student findStudentByStudentId(Integer studentId);
//    public Student getStudentByStudentId(Integer studentId);
//    public Student findByStudentId(Integer studentId);
    List<Student> findAllByFirstNameContainingOrLastNameContainingOrMiddleNameContainingOrCgpaContainingOrEnrollmentDateContainingOrStudentIdContainingOrStudentNumberContaining(
            String lastName, String firstName, String middleName, String cgpa, String enrollmentDate, String studentId, String studentNumber
    );
    List<Student> findAllByFirstNameContainingOrLastNameContainingOrMiddleNameContaining(
            String lastName, String firstName, String middleName
    );
    // Custom Query Using JPQL
    @Query(value = "select s from Student s where s.firstName = :name")
    Optional<Student> getStudentByStudentName(String name);

    /*@Query(value = "select * from students s where s.firstName like %?1%" , nativeQuery = true)
    Optional<Student> getStudentWhereNameStartWith(String nameStart);*/
}
