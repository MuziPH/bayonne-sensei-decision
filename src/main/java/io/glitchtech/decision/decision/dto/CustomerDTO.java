package io.glitchtech.decision.decision.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record CustomerDTO(@NotBlank(message = "First name cannot be blank")
                          String firstName,
                          @NotBlank(message = "First name cannot be blank")
                          String lastName,
                          @NotNull(message = "Birth date cannot be null or in the future")
                          @Past(message = "Birth date cannot be in the future")
                          LocalDate birthDate,
                          @NotNull(message = "email address cannot be null")
                          @Email(message = "invalid email address")
                          String emailAddress,
                          @NotNull
                          Integer ssn
) {
}
