package com.certified.notes.note.repository

import com.certified.notes.note.model.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface NoteRepository : JpaRepository<Note, Long> {

//    @Query("SELECT s FROM Student s WHERE s.email = ?1")
//    fun findStudentByEmail(email: String): Optional<Student>

    @Query("SELECT n FROM Note n WHERE n.courseCode = ?1")
    fun findCourseNotes(courseCode: String): Optional<List<Note>>
}