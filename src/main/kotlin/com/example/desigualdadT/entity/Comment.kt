package com.example.desigualdadT.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "students_registered_view")
class StudentsRegisteredView {
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name= "full_name")
    var fullName: String? = null

    var email: String? = null

    var phone: String? = null

    var address: String? = null
}