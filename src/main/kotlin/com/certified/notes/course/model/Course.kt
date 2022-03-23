package com.certified.notes.course.model

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table
data class Course(
    @Column(nullable = false) @Id @SequenceGenerator(
        name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1
    ) @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence") val id: Long = 0L,
    var title: String = "",
    var code: String = "",
    @Column(columnDefinition = "text") var description: String = "",
    var color: Long = 0L,
    var unit: Int = 0,
    var score: Int = 0,
) {
    var grade = when {
        score >= 70 -> 'A'
        score >= 60 -> 'B'
        score >= 50 -> 'C'
        score >= 45 -> 'D'
        else -> 'F'
    }

    var gradePoint: Int = when {
        score >= 70 -> 5
        score >= 60 -> 4
        score >= 50 -> 3
        score >= 45 -> 2
        else -> 0
    }

    var creditPoint = gradePoint * unit
    var noOfCourses = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Course

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , title = $title , code = $code , description = $description , color = $color , unit = $unit , score = $score , gradePoint = $gradePoint , creditPoint = $creditPoint , grade = $grade )"
    }
}