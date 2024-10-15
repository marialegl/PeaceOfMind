package com.menteenpaz.domain

import jakarta.persistence.*
import java.util.*
import com.menteenpaz.domain.Consultant

@Entity
@Table(name = "reasons_for_consultation")
data class ReasonForConsultation(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "consultant_id", nullable = false)
    val consultant: Consultant,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "initial_evaluation", nullable = true)
    val initialEvaluation: String? = null,

    @ElementCollection
    @CollectionTable(name = "therapeutic_tasks", joinColumns = [JoinColumn(name = "reason_for_consultation_id")])
    @Column(name = "task")
    val therapeuticTasks: MutableSet<String> = mutableSetOf(),

    @ElementCollection
    @CollectionTable(name = "symptom_diary", joinColumns = [JoinColumn(name = "reason_for_consultation_id")])
    @Column(name = "symptom")
    val symptomDiary: MutableSet<String> = mutableSetOf(),

    @Column(name = "initial_symptoms", nullable = true)
    val initialSymptoms: String? = null,

    @Column(name = "scheduled_sessions", nullable = true)
    val scheduledSessions: Int? = null
) {
    fun registerTherapeuticTasks(task: String) {
        therapeuticTasks.add(task)
    }

    fun consultSymptomDiary(): Set<String> {
        return symptomDiary
    }

    fun registerInitialSymptoms(symptoms: String) {
        // This will store the initial symptoms for the consultation
        if (initialSymptoms.isNullOrEmpty()) {
            initialSymptoms = symptoms
        }
    }

    fun scheduleTherapy(sessions: Int) {
        scheduledSessions = sessions
    }
}
