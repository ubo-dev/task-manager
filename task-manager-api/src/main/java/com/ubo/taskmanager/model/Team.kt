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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Team

        if (id != other.id) return false
        if (name != other.name) return false
        if (member != other.member) return false
        if (task != other.task) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (member?.hashCode() ?: 0)
        result = 31 * result + (task?.hashCode() ?: 0)
        return result
    }


}
