    package edu.miu.cs.cs425.eregistrarapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
//@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @NotNull(message = "student Number can not be null") // for the bean
    @NotEmpty(message = "student Number can not be empty string or null")
    @NotBlank(message = "student Number can not be blanc, empty string or null")
    @Column(nullable = false) // this one will appear on the database
    private String studentNumber;

    @NotBlank(message = "First Name can not be blanc, empty string or null")
    @Column(nullable = false)
    private String firstName;
    private String middleName;

    @NotBlank(message = "Last Name can not be blanc, empty string or null")
    @Column(nullable = false)
    private String lastName;
    private double cgpa;

    @NotNull(message = "enrollmentDate can not be null")
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;

    @NotBlank(message = "Is International can not be blanc, empty string or null")
    @Column(nullable = false)
    private String isInternational;

}
