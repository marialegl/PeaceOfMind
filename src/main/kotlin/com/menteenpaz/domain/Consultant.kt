package com.menteenpaz.domain

import com.menteenpaz.domain.enums.SexEnum
import jakarta.persistence.*
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "consultants")
data class Consultant(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: UUID? = null,

    val name: String,

    @Column(name = "last_name")
    val lastName: String,

    val birthday: LocalDate,

    @Enumerated(EnumType.STRING)
    val sex: SexEnum,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "therapist_id", nullable = false)
    val therapist: Therapist
)
