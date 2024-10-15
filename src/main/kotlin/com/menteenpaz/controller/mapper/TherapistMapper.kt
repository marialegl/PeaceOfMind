package com.menteenpaz.controller.mapper

import com.menteenpaz.controller.dto.TherapistDto
import com.menteenpaz.domain.Therapist

fun Therapist.toDto(): TherapistDto = TherapistDto(
    id = this.id,
    name = this.name,
    lastName = this.lastName,
    vocationalTraining = this.vocationalTraining,
    yearsOfExperience = this.yearsOfExperience,
)

fun TherapistDto.toEntity(): Therapist = Therapist(
    id = this.id,
    name = this.name,
    lastName = this.lastName,
    vocationalTraining = this.vocationalTraining,
    yearsOfExperience = this.yearsOfExperience,
)