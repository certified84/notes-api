package com.certified.notes.note.model

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table
data class Note(
    @Column(nullable = false)
    @Id @SequenceGenerator(
        name = "note_sequence",
        sequenceName = "note_sequence",
        allocationSize = 1
    ) @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_sequence") val id: Long = 0L,
    var title: String = "",
    @Column(columnDefinition = "text")
    var content: String = "",
    var color: Long = 0L,
    var courseCode: String = "",
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Note

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , title = $title , content = $content , color = $color , courseCode = $courseCode )"
    }
}