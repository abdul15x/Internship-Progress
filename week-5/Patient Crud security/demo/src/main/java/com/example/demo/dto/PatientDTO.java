package com.example.demo.dto;

import com.example.demo.exception.ValidPatientStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name cannot be blank")
    @Size(
            min = 2,
            max = 50,
            message = "Name must be between 2 and 50 characters"
    )
    private String name;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Status is required")
    @ValidPatientStatus
    private String status;

    @NotNull(message = "Age is required")
    @Min(
            value = 1,
            message = "Age must be at least 1"
    )
    @Max(
            value = 120,
            message = "Age cannot be greater than 120"
    )
    private Integer age;
}