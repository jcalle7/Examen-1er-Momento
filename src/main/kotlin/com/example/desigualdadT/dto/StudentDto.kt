package com.example.desigualdadT.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

class StudentDto {

    @NotNull(message = "Full name is required")
    @NotBlank(message = "Name is required")
    var fullName: String? = null

    @NotBlank(message = "Email is required")
    @NotNull(message = "Email is required")
    var email: String? = null
}