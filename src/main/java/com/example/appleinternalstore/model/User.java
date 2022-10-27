package com.example.appleinternalstore.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Document("user")
@Data
public class User {

    @Id
    private String id;

    @NotBlank(message = "* Email is required")
    @Email(message = "{errors.invalid_email}")
    private String email;

    private String address;

    private int phoneNumber;

    @NotBlank(message = "* First Name is required")
    private String firstname;

    @NotBlank(message = "* Last Name is required")
    private String lastname;

    @NotBlank(message = "* Username is required")
    private String username;

    @NotBlank(message = "* Password is required")
    @Size(min = 8)
    private String password;

}
