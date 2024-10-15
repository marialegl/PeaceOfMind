package com.menteenpaz.domain

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "therapists")
data class Therapist(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: UUID? = null,

    val name: String,

    @Column(name = "last_name")
    val lastName: String,

    @Column(name = "vocational_training")
    val vocationalTraining: String,

    @Column(name = "years_of_experience")
    val yearsOfExperience: Int,

    @OneToMany(mappedBy = "therapist")
    val consultants: MutableSet<Consultant> = mutableSetOf()
)