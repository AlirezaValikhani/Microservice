package com.example.microservice.validation;

import javax.naming.InvalidNameException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FirstNameConstraintValidator implements ConstraintValidator<FirstName,String> {

    @Override
    public void initialize(FirstName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for (Character ch:s.toCharArray()) {
            if(Character.isDigit(ch)){
                try {
                    throw new InvalidNameException();
                } catch (InvalidNameException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;
    }
}
