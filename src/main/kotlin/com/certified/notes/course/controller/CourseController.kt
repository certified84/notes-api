package com.certified.notes.course.controller

import com.certified.notes.course.model.Course
import com.certified.notes.course.service.CourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Query
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["api/v1/courses"])
class CourseController constructor(@Autowired private val service: CourseService) {

    @GetMapping
    fun getCourses() = service.getCourses()

    @GetMapping(path = ["{id}"])
    fun getCourseWithID(@PathVariable("id") id: Long) = service.getCourseWithID(id)

    @Query(value = "courseCode")
    fun getNotesWithCourseCode(@RequestParam("courseCode") courseCode: String) =
        service.getNotesWithCourseCode(courseCode)

    @PostMapping
    fun createCourse(@RequestBody course: Course) = service.addNewCourse(course)

    @DeleteMapping(path = ["{id}"])
    fun delete(@PathVariable("id") id: Long) = service.deleteCourse(id)

    @PutMapping(path = ["{id}"])
    fun updateCourse(
        @PathVariable("id") id: Long,
        @RequestBody course: Course
    ) =
        service.updateCourse(id, course)
}