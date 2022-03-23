package com.certified.notes.note.service

import com.certified.notes.note.model.Message
import com.certified.notes.note.model.Note
import com.certified.notes.note.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NoteService constructor(@Autowired private val repository: NoteRepository) {

    fun getNotes(): List<Note> = repository.findAll()

    fun addNewNote(note: Note): Message {
        println(note)
        repository.save(note)
        return Message("Note added successfully")
    }

    fun deleteNote(id: Long): Message {
        val exists = repository.existsById(id)
        println(id)
        if (!exists) throw IllegalStateException("Selected note doesn't exists.")
        repository.deleteById(id)
        return Message("Note deleted successfully")
    }

    fun getNoteWithID(id: Long): Note {
        val exists = repository.existsById(id)
        println(id)
        if (!exists) throw IllegalStateException("Student with id $id does not exists.")
        return repository.getById(id)
    }

    @Transactional
    fun updateNote(id: Long, update: Note): Note {
        val note =
            repository.findById(id).orElseThrow { (IllegalStateException("Selected note doesn't exists.")) }

        if (update.title.isNotBlank()) note.title = update.title

        if (update.content.isNotBlank()) note.content = update.content

        if (update.color != 0L) note.color = update.color

        if (update.courseCode.isNotBlank()) note.courseCode = update.courseCode

        return note
    }
}