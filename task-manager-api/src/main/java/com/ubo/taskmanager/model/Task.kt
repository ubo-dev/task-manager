package com.ubo.taskmanager.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

// title, description, due date, priority, and status (e.g., open, in progress, completed).
@Entity
data class Task(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id : String = "",
    var title: String?,
    var description: String?,

    @Enumerated(EnumType.STRING)
    var priority: Priority? = Priority.URGENT,

    @Enumerated(EnumType.STRING)
    var status: Status? = Status.OPEN,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "team_id", nullable = true)
    var team: Team?
) {

    constructor(title: String, description: String) : this(
        "",
        title = title,
        description = description,
        priority = Priority.URGENT,
        status = Status.OPEN,
        null
    ) {

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Task

        if (id != other.id) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (priority != other.priority) return false
        if (status != other.status) return false
        if (team != other.team) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (priority?.hashCode() ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        result = 31 * result + (team?.hashCode() ?: 0)
        return result
    }


}

enum class Status {
    OPEN, INPROGRESS, COMPLETED
}

enum class Priority {
    URGENT, NONCURUCIAL
}
