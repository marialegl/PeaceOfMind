package com.menteenpaz.controller

import com.menteenpaz.controller.dto.ConsultantDto
import com.menteenpaz.service.ConsultantService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ConsultantController(
    private val consultantService: ConsultantService
) {

    @PostMapping("/consultants")
    fun createConsultant(@RequestBody consultantDto: ConsultantDto): ResponseEntity<ConsultantDto> {
        return ResponseEntity(consultantService.createConsultant(consultantDto), HttpStatus.CREATED)
    }

    @GetMapping("/consultants")
    fun getConsultants(): ResponseEntity<List<ConsultantDto>> {
        return ResponseEntity(consultantService.getConsultants(), HttpStatus.OK)
    }

    @GetMapping("/consultants/{id}")
    fun getConsultantById(@PathVariable("id") id: UUID): ResponseEntity<ConsultantDto> {
        val consultant = consultantService.getConsultantById(id)
        return if (consultant != null) {
            ResponseEntity(consultant, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/consultants/{id}")
    fun updateConsultant(@PathVariable("id") id: UUID, @RequestBody consultantDto: ConsultantDto): ResponseEntity<ConsultantDto> {
        val consultant = consultantService.updateConsultant(id, consultantDto)

        return if (consultant != null) {
            ResponseEntity(consultant, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/consultants/{id}")
    fun deleteConsultant(@PathVariable("id") id: UUID): ResponseEntity<Unit> {
        return ResponseEntity(consultantService.deleteConsultant(id), HttpStatus.NO_CONTENT)
    }
}
