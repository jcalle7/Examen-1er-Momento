package com.example.desigualdadT.entity

import jakarta.persistence.*

@Entity
@Table(name = "student")
class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var fullName: String? = null
    var email: String? = null
    var phone: String? = null
    var address: String? = null
}