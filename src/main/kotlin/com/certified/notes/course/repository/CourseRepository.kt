package com.certified.notes.course.repository

import com.certified.notes.course.model.Course
import com.certified.notes.note.model.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CourseRepository : JpaRepository<Course, Long> {

    @Query("SELECT n FROM Note n WHERE n.courseCode = ?1")
    fun findCourseNotes(courseCode: String): Optional<List<Note>>
}