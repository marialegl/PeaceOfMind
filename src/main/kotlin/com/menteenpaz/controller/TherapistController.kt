package com.menteenpaz.controller

import com.menteenpaz.controller.dto.TherapistDto
import  com.menteenpaz.service.TherapistService
import org.springframework.http.HttpStatus
import  org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class TherapistController (
    private val therapistService: TherapistService
){
    @PostMapping("/therapist")
    fun createTherapist(@RequestBody therapistDto: TherapistDto): ResponseEntity<TherapistDto>{
        return ResponseEntity(therapistService.createTherapist(therapistDto), HttpStatus.CREATED)
    }

    @GetMapping("/therapist")
    fun getAllTherapist(): ResponseEntity<List<TherapistDto>> {
        return ResponseEntity(therapistService.getTherapist(), HttpStatus.OK)
    }

    @GetMapping("/therapist/{id}")
    fun getTherapistById(@PathVariable("id") id: UUID): ResponseEntity<TherapistDto> {
        val therapist = therapistService.getTherapistById(id)
        if (therapist === null) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(therapist, HttpStatus.OK)
    }

    @PutMapping("/therapist/{id}")
    fun updateTherapist(@PathVariable("id") id: UUID, @RequestBody therapistDto: TherapistDto): ResponseEntity<TherapistDto> {
        val therapist = therapistService.updateTherapist(id,therapistDto)

        if (therapist === null) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(therapist, HttpStatus.OK)
    }

    @DeleteMapping("/therapist/{id}")
    fun deleteTherapist(@PathVariable("id") id: UUID): ResponseEntity<Unit> {
        return ResponseEntity(therapistService.deleteTherapist(id), HttpStatus.NO_CONTENT)
    }

}