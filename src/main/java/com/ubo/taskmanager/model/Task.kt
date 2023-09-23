package com.ubo.taskmanager.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

// title, description, due date, priority, and status (e.g., open, in progress, completed).
@Entity
data class Task(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id : String? = "",
    var title: String?,
    var description: String?,
    var priority: Priority? = Priority.URGENT,
    var status: Status? = Status.OPEN,

    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "team_id", nullable = false)
    var team: Team?
) {
    constructor(title: String?, description: String?, priority: Priority?, status: Status?,team: Team?) : this(
        "",
        title = title,
        description = description,
        priority = priority,
        status = status,
        team = team
    ) {

    }
}

enum class Status {
    OPEN, INPROGRESS, COMPLETED
}

enum class Priority {
    URGENT, NONCURUCIAL
}
