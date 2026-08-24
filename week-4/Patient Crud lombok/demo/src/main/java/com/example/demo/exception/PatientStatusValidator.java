package com.example.demo.exception;

import com.example.demo.exception.ValidPatientStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PatientStatusValidator
        implements ConstraintValidator<ValidPatientStatus, String> {

    @Override
    public boolean isValid(
            String status,
            ConstraintValidatorContext context) {

        if (status == null) {
            return false;
        }

        return status.equals("Active")
                || status.equals("Inactive");
    }
}