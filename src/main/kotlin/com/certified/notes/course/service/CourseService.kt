package com.certified.notes.course.service

import com.certified.notes.course.model.Course
import com.certified.notes.course.model.Message
import com.certified.notes.course.repository.CourseRepository
import com.certified.notes.note.model.Note
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CourseService constructor(@Autowired private val repository: CourseRepository) {

    fun getCourses(): List<Course> = repository.findAll()

    fun addNewCourse(course: Course): Message {
        println(course)
        repository.save(course)
        return Message("Course added successfully")
    }

    fun deleteCourse(id: Long): Message {
        val exists = repository.existsById(id)
        println(id)
        if (!exists) throw IllegalStateException("Selected course doesn't exists.")
        repository.deleteById(id)
        return Message("Course deleted successfully")
    }

    fun getCourseWithID(id: Long): Course {
        val exists = repository.existsById(id)
        println(id)
        if (!exists) throw IllegalStateException("Selected course doesn't exists.")
        return repository.getById(id)
    }

    fun getNotesWithCourseCode(courseCode: String): List<Note> {
        val notes = repository.findCourseNotes(courseCode)
            .orElseThrow { IllegalStateException("Notes with course code $courseCode doesn't exists.") }
        return notes
    }

    @Transactional
    fun updateCourse(id: Long, update: Course): Course {
        val note =
            repository.findById(id).orElseThrow { (IllegalStateException("Selected course doesn't exists.")) }

        if (update.title.isNotBlank()) note.title = update.title

        if (update.code.isNotBlank()) note.code = update.code

        if (update.description.isNotBlank()) note.description = update.description

        if (update.color != 0L) note.color = update.color

        if (update.unit != 0) note.unit = update.unit

        if (update.score != 0) {
            note.score = update.score
            note.grade = when {
                update.score >= 70 -> "A"
                update.score >= 60 -> "B"
                update.score >= 50 -> "C"
                update.score >= 45 -> "D"
                else -> "F"
            }
            note.gradePoint = when {
                update.score >= 70 -> 5
                update.score >= 60 -> 4
                update.score >= 50 -> 3
                update.score >= 45 -> 2
                else -> 0
            }
            note.creditPoint = note.gradePoint * note.unit
        }

        if (update.gradePoint != 0) note.gradePoint = update.gradePoint

        return note
    }
}