package com.menteenpaz.controller.dto

import java.time.LocalDate
import java.util.*

data class ConsultantDto(
    val id: UUID? = null,
    val name: String,
    val lastName: String,
    val birthday: LocalDate,
    val sex: String,
    val therapistName: String,
    val therapist: TherapistDto
)
