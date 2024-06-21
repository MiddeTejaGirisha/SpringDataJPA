package com.example.DTOClassBasedProjections;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, message = "First name must have at least 2 characters")
    private String firstName;
    private String lastName;

    public EmployeeDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
