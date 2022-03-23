package com.certified.notes.todo.model

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table
data class Todo(
    @Column(nullable = false)
    @Id @SequenceGenerator(
        name = "note_sequence",
        sequenceName = "note_sequence",
        allocationSize = 1
    ) @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_sequence") val id: Long = 0L,
    @Column(columnDefinition = "text")
    var todo: String = "",
    var isDone: Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Todo

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , todo = $todo , isDone = $isDone )"
    }
}