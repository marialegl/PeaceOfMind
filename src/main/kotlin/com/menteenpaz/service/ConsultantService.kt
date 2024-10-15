package com.menteenpaz.service

import com.menteenpaz.controller.dto.ConsultantDto
import com.menteenpaz.controller.mapper.toDTO
import com.menteenpaz.controller.mapper.toEntity
import com.menteenpaz.repository.ConsultantRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ConsultantService(
    private val consultantRepository: ConsultantRepository
) {

    fun createConsultant(consultantDto: ConsultantDto): ConsultantDto {
        val response = consultantRepository.save(consultantDto.toEntity())
        return response.toDTO()
    }

    fun getConsultants(): List<ConsultantDto> {
        return consultantRepository.findAll().map { it.toDTO() }
    }

    fun getConsultantById(id: UUID): ConsultantDto? {
        val response = consultantRepository.findById(id)
        return if (response.isPresent) {
            response.get().toDTO()
        } else {
            null
        }
    }

    fun updateConsultant(id : UUID, consultantDto: ConsultantDto): ConsultantDto? {
        val response = consultantRepository.findById(id)

        if (!response.isPresent) {
            return null
        }

        if (id != consultantDto.id) {
            return null
        }
        return consultantRepository.save(consultantDto.toEntity()).toDTO()
    }

    fun deleteConsultant(id: UUID) {
        consultantRepository.deleteById(id)
    }
}