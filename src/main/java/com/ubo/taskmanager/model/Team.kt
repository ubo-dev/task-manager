package com.ubo.taskmanager.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
data class Team(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,
    val name: String?,

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    val member: Set<Member>?,

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    val task: Set<Task>?
) {
    constructor(name: String) : this(
        "",
        name = name,
        member = null,
        task = null
    ) {

    }
}
