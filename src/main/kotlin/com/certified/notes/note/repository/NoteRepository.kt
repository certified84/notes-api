package com.certified.notes.note.repository

import com.certified.notes.note.model.Note
import com.certified.notes.student.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface NoteRepository : JpaRepository<Note, Long> {

//    @Query("SELECT s FROM Student s WHERE s.email = ?1")
//    fun findStudentByEmail(email: String): Optional<Student>
}