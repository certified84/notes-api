package com.certified.notes.note.config

import com.certified.notes.student.repository.StudentRepository
import com.certified.notes.student.model.Student
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.Month

@Configuration
class NoteConfig {
//    @Bean
//    fun commandLineRunner(repository: StudentRepository): CommandLineRunner {
//        return CommandLineRunner {
//            repository.saveAll(
//                listOf(
//                    Student(
//                        name = "Mariam",
//                        email = "mariam.jamal@gmail.com",
//                        dob = LocalDate.of(2000, Month.JANUARY, 5)
//                    ),
//                    Student(
//                        name = "Samson",
//                        email = "achiagasamson5@gmail.com",
//                        dob = LocalDate.of(2005, Month.FEBRUARY, 25)
//                    ),
//                    Student(name = "Smith"),
//                    Student(name = "Shola"),
//                    Student(name = "Dolapo"),
//                    Student(name = "Esther")
//                )
//            )
//        }
//    }
}