package com.example.project_esd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CustomerRequest(@NotBlank(message = "First name is required")
                              @JsonProperty("first_name")
                              String firstName,

                              @JsonProperty("last_name")
                              String lastName,

                              @NotNull(message = "Customer email is required")
                              @Email(message = "Email must be in a valid format")
                              @JsonProperty("email")
                              String email,

                              @NotBlank(message = "Password is required")
                              @Size(min = 6, max = 12, message = "Password must be between 6 and 12 characters")
                              @JsonProperty("password")
                              String password
) {
}
