package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotation.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
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
    @AssertTrue(message = "Employee must be active")
    private Boolean isActive;

    @NotBlank(message = "Role cannot be null or empty")
//    @Pattern(regexp = "ADMIN|USER|MANAGER", message = "Role must be either ADMIN, USER, or MANAGER")
    @EmployeeRoleValidation(message = "Role must be either ADMIN, USER, or MANAGER")
    private String role;

    @NotNull
    @Digits(integer = 10, fraction = 2, message = "Salary must be a valid monetary amount with up to 10 digits and 2 decimal places")
    @Positive(message = "Salary must be positive")
    @DecimalMin( value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    @DecimalMax( value = "1000000.0", inclusive = true, message = "Salary must be less than or equal to 1,000,000")
    private Double salary;

}
