package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name cannot be null or empty")
    @NotBlank
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 75, message = "Age should not be greater than 65")
    private Integer age;

    @PastOrPresent(message = "Date of joining cannot be in the future")
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private Boolean isActive;

    @NotBlank(message = "Role cannot be null or empty")
    @Pattern(regexp = "ADMIN|USER|MANAGER", message = "Role must be either ADMIN, USER, or MANAGER")
    private String role;

    @NotNull
    @Digits(integer = 10, fraction = 2, message = "Salary must be a valid monetary amount with up to 10 digits and 2 decimal places")
    @Positive(message = "Salary must be positive")
    private Double salary;
}
