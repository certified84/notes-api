package com.certified.notes.todo.repository

import com.certified.notes.todo.model.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TodoRepository : JpaRepository<Todo, Long> {

    @Query("SELECT t FROM Todo t WHERE t.isDone = ?1")
    fun findCompletedTodo(isDone: Boolean): Optional<List<Todo>>
}