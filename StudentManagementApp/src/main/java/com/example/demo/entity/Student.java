package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotBlank(message = "First name is mandatory and should be more than 3 characters")
//    @Size(min = 3, message = "First name should be more than 3 characters")
    private String firstName;

//    @NotBlank(message = "Last name is mandatory and should be more than 3 characters")
//    @Size(min = 3, message = "Last name should be more than 3 characters")
    private String lastName;

//    @NotNull(message = "Age is mandatory and should be greater than 18")
//    @Min(value = 18, message = "Age should be greater than 18")
    private Integer age;

//    @NotBlank(message = "Date of birth is mandatory")
//    @DateTimeFormat(pattern = "mm-dd-yyyy")
    private String dateOfBirth;

//    @NotBlank(message = "Gender is mandatory")
    private String gender;

//    @NotBlank(message = "Mobile number is mandatory and should be 10 digits")
//    @Pattern(regexp = "\\d{10}", message = "Mobile number should be 10 digits")
    private String mobileNumber;

//    @NotBlank(message = "Email ID is mandatory")
//    @Email(message = "Invalid email format")
    private String email;

//    @NotBlank(message = "Birth place is mandatory")
    private String birthPlace;
	
	

}
