package com.menteenpaz.repository

import com.menteenpaz.domain.Therapist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TherapistRepository : JpaRepository<Therapist, UUID> {
}