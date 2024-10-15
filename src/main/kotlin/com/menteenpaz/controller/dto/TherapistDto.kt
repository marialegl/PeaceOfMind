package com.menteenpaz.controller.dto

import java.util.*

data class TherapistDto(
    val id: UUID? = null,
    val name: String,
    val lastName: String,
    val vocationalTraining: String,
    val yearsOfExperience: Int,
    val consultants: MutableSet<ConsultantDto> = mutableSetOf()
)
