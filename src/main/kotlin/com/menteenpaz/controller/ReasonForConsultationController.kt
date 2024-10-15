package com.menteenpaz.controller

import com.menteenpaz.controller.dto.ReasonForConsultationDto
import com.menteenpaz.service.ReasonForConsultationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ReasonForConsultationController(
    private val reasonForConsultationService: ReasonForConsultationService
) {

    // Create a new reason for consultation
    @PostMapping("/reasons-for-consultation")
    fun createReasonForConsultation(@RequestBody reasonForConsultationDto: ReasonForConsultationDto): ResponseEntity<ReasonForConsultationDto> {
        return ResponseEntity(reasonForConsultationService.createReasonForConsultation(reasonForConsultationDto), HttpStatus.CREATED)
    }

    // Get all reasons for consultation
    @GetMapping("/reasons-for-consultation")
    fun getAllReasonsForConsultation(): ResponseEntity<List<ReasonForConsultationDto>> {
        return ResponseEntity(reasonForConsultationService.getAllReasonsForConsultation(), HttpStatus.OK)
    }

    // Get a reason for consultation by ID
    @GetMapping("/reasons-for-consultation/{id}")
    fun getReasonForConsultationById(@PathVariable("id") id: UUID): ResponseEntity<ReasonForConsultationDto> {
        val reasonForConsultation = reasonForConsultationService.getReasonForConsultationById(id)
        return if (reasonForConsultation != null) {
            ResponseEntity(reasonForConsultation, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    // Update a reason for consultation by ID
    @PutMapping("/reasons-for-consultation/{id}")
    fun updateReasonForConsultation(@PathVariable("id") id: UUID, @RequestBody reasonForConsultationDto: ReasonForConsultationDto): ResponseEntity<ReasonForConsultationDto> {
        val reasonForConsultation = reasonForConsultationService.updateReasonForConsultation(id, reasonForConsultationDto)
        return if (reasonForConsultation != null) {
            ResponseEntity(reasonForConsultation, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    // Delete a reason for consultation by ID
    @DeleteMapping("/reasons-for-consultation/{id}")
    fun deleteReasonForConsultation(@PathVariable("id") id: UUID): ResponseEntity<Unit> {
        return ResponseEntity(reasonForConsultationService.deleteReasonForConsultation(id), HttpStatus.NO_CONTENT)
    }

    // Register therapeutic tasks
    @PostMapping("/reasons-for-consultation/{id}/tasks")
    fun registerTherapeuticTasks(@PathVariable("id") id: UUID): ResponseEntity<Void> {
        reasonForConsultationService.registerTherapeuticTasks(id)
        return ResponseEntity(HttpStatus.OK)
    }

    // Consult the symptom diary for a specific consultante
    @GetMapping("/reasons-for-consultation/{id}/symptom-diary")
    fun consultSymptomDiary(@PathVariable("id") id: UUID): ResponseEntity<List<String>> {
        val symptoms = reasonForConsultationService.consultSymptomDiary(id)
        return ResponseEntity(symptoms, HttpStatus.OK)
    }

    // Register initial symptoms by therapist
    @PostMapping("/reasons-for-consultation/{id}/initial-symptoms")
    fun registerInitialSymptoms(@PathVariable("id") id: UUID): ResponseEntity<Void> {
        reasonForConsultationService.registerInitialSymptoms(id)
        return ResponseEntity(HttpStatus.OK)
    }

    // Schedule therapy and specify session count
    @PostMapping("/reasons-for-consultation/{id}/schedule-therapy")
    fun scheduleTherapy(@PathVariable("id") id: UUID, @RequestParam sessions: Int): ResponseEntity<Void> {
        reasonForConsultationService.scheduleTherapy(id, sessions)
        return ResponseEntity(HttpStatus.OK)
    }
}
