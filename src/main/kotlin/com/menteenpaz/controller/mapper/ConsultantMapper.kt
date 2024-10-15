package com.menteenpaz.controller.mapper

import com.menteenpaz.domain.Consultant
import com.menteenpaz.controller.dto.ConsultantDto
import com.menteenpaz.domain.enums.SexEnum


fun Consultant.toDTO(): ConsultantDto = ConsultantDto(
    id = this.id,
    name = this.name,
    lastName = this.lastName,
    birthday = this.birthday,
    sex = this.sex.name,
    therapistName = this.therapist.name + " " + this.therapist.lastName,
    therapist = this.therapist.toDto()
)

fun ConsultantDto.toEntity(): Consultant = Consultant(
    id = this.id,
    name = this.name,
    lastName = this.lastName,
    birthday = this.birthday,
    sex = SexEnum.valueOf(this.sex),
    therapist = this.therapist.toEntity()
)