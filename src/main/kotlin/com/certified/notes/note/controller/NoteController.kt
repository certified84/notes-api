package com.certified.notes.note.controller

import com.certified.notes.note.model.Note
import com.certified.notes.note.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["api/v1/notes"])
class NoteController constructor(@Autowired private val service: NoteService) {

    @GetMapping
    fun getNotes() = service.getNotes()

    @GetMapping(path = ["{id}"])
    fun getNoteWithID(@PathVariable("id") id: Long) = service.getNoteWithID(id)

    @PostMapping
    fun createNote(@RequestBody note: Note) = service.addNewNote(note)

    @DeleteMapping(path = ["{id}"])
    fun delete(@PathVariable("id") id: Long) = service.deleteNote(id)

    @PutMapping(path = ["{id}"])
    fun updateNote(
        @PathVariable("id") id: Long,
        @RequestBody note: Note
    ) =
        service.updateNote(id, note)
}