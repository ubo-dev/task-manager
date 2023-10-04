package com.ubo.taskmanager.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.LazyGroup

@Entity
data class User(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" ,strategy = "org.hibernate.id.UUIDGenerator")
    var id: String,
    var firstName: String?,
    var lastName: String?,
    @Column(nullable = false, unique = true)
    var userName: String,
    @Column(nullable = false, unique = true)
    var email: String,
    var phoneNumber: String,
    @Column(nullable = false)
    var password: String,

    @ManyToMany
    @LazyGroup(value = "role")
    var roles: Set<Role>

) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (userName != other.userName) return false
        if (email != other.email) return false
        if (phoneNumber != other.phoneNumber) return false
        if (password != other.password) return false
        if (roles != other.roles) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (firstName?.hashCode() ?: 0)
        result = 31 * result + (lastName?.hashCode() ?: 0)
        result = 31 * result + userName.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + phoneNumber.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + roles.hashCode()
        return result
    }
}
