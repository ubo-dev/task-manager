package com.ubo.taskmanager.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.GenericGenerator

@Entity
data class Member(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String,
    val firstName: String,
    val lastName: String,

    @ManyToOne(fetch = FetchType.LAZY ,cascade = [CascadeType.ALL])
    @JoinColumn(name = "team_id", nullable = true)
    val team: Team?
){
    constructor(firstName: String,lastName: String) : this(
        "",
        firstName = firstName,
        lastName = lastName,
        null
    ) {

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Member

        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (team != other.team) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + (team?.hashCode() ?: 0)
        return result
    }


}
