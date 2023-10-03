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
}

enum class Status {
    OPEN, INPROGRESS, COMPLETED
}

enum class Priority {
    URGENT, NONCURUCIAL
}
