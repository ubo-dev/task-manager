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
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUID")
    val id: String,
    val firstName: String,
    val lastName: String,

    @ManyToOne(fetch = FetchType.LAZY ,cascade = [CascadeType.ALL])
    @JoinColumn(name = "team_id", nullable = false)
    val team: Team
){
    constructor(firstName: String,lastName: String,team: Team) : this(
        "",
        firstName = firstName,
        lastName = lastName,
        team = team
    ) {

    }
}
