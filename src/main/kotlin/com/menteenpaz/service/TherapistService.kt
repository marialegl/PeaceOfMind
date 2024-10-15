package com.menteenpaz.service

import com.menteenpaz.controller.dto.TherapistDto
import com.menteenpaz.controller.mapper.toDto
import com.menteenpaz.controller.mapper.toEntity
import com.menteenpaz.repository.TherapistRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TherapistService (
    private val therapistRepository: TherapistRepository
){
    fun createTherapist(therapistDto: TherapistDto): TherapistDto {
        val response = therapistRepository.save(therapistDto.toEntity())
        return response.toDto()
    }

    fun getTherapist(): List<TherapistDto> {
       return therapistRepository.findAll().map {it.toDto()}
    }

    fun getTherapistById(id: UUID):TherapistDto? {
        val response = therapistRepository.findById(id)

        if (!response.isPresent) {
            return null
        }
        return response.get().toDto()
    }

    fun updateTherapist(id: UUID, therapistDto: TherapistDto): TherapistDto? {
        val response = therapistRepository.findById(id)

        if (!response.isPresent) {
            return null
        }

        if (id != therapistDto.id) {
            return null
        }
        return therapistRepository.save(therapistDto.toEntity()).toDto()
    }

    fun deleteTherapist(id: UUID) {
        therapistRepository.deleteById(id)
    }
}