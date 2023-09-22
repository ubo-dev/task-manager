package com.ubo.taskmanager.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator

// title, description, due date, priority, and status (e.g., open, in progress, completed).
@Entity
data class Task(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id : String? = "",
    var title: String,
    var description: String?,
    var priority: Prioritiy? = Prioritiy.URGENT,
    var status: Status? = Status.OPEN
) {
    constructor(title: String, description: String, priority: Prioritiy, status: Status) : this(
        "",
        title = title,
        description = description,
        priority = priority,
        status = status,
    ) {

    }
}

enum class Status {
    OPEN, INPROGRESS, COMPLETED
}

enum class Prioritiy {
    URGENT, NONCURUCIAL
}
