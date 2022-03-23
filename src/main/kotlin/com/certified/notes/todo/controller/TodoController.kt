package com.certified.notes.todo.controller

import com.certified.notes.todo.model.Todo
import com.certified.notes.todo.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["api/v1/todos"])
class TodoController constructor(@Autowired private val service: TodoService) {

    @GetMapping
    fun getTodos() = service.getAllTodo()

    @PostMapping
    fun createTodo(@RequestBody note: Todo) = service.addNewTodo(note)

    @DeleteMapping(path = ["{id}"])
    fun delete(@PathVariable("id") id: Long) = service.deleteTodo(id)

    @DeleteMapping
    fun deleteCompletedTodo() = service.deleteCompletedTodo()

    @PutMapping(path = ["{id}"])
    fun updateTodo(
        @PathVariable("id") id: Long,
        @RequestBody todo: Todo
    ) =
        service.updateTodo(id, todo)
}