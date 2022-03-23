package com.certified.notes.todo.service

import com.certified.notes.todo.model.Message
import com.certified.notes.todo.model.Todo
import com.certified.notes.todo.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoService constructor(@Autowired private val repository: TodoRepository) {

    fun getAllTodo(): List<Todo> = repository.findAll()

    fun addNewTodo(todo: Todo): Message {
        println(todo)
        repository.save(todo)
        return Message("Todo added successfully")
    }

    fun deleteTodo(id: Long): Message {
        val exists = repository.existsById(id)
        println(id)
        if (!exists) throw IllegalStateException("Selected todo doesn't exists.")
        repository.deleteById(id)
        return Message("Todo deleted successfully")
    }

    fun deleteCompletedTodo(): Message {
        val completed =
            repository.findCompletedTodo(true).orElseThrow { (IllegalStateException("You haven't completed any todo")) }
        repository.deleteAll(completed)
        return Message("Completed To-Dos deleted successfully")
    }

    @Transactional
    fun updateTodo(id: Long, update: Todo): Todo {
        val todo =
            repository.findById(id).orElseThrow { (IllegalStateException("Selected todo doesn't exists.")) }

        if (update.todo.isNotBlank()) todo.todo = update.todo

        todo.isDone = update.isDone

        return todo
    }
}