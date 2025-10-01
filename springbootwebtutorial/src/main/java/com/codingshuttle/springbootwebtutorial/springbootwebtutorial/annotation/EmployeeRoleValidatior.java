package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidatior implements ConstraintValidator<EmployeeRoleValidation, String> {


    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        List<String> validRoles = List.of("ADMIN", "USER", "MANAGER");
        if (inputRole != null && validRoles.contains(inputRole)) {
            return true;
        }
        return false;
    }
}
