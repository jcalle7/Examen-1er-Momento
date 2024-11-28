package com.example.desigualdadT.entity

import jakarta.persistence.*

@Entity
@Table(name = "student")
class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(nullable = false)
    var fullName: String? = null

    @Column(nullable = false, unique = true)
    var email: String? = null

    var phone: String? = null

    var address: String? = null

    @OneToMany(mappedBy = "student", cascade = [CascadeType.ALL], orphanRemoval = true)
    var comments: MutableSet<Comment> = mutableSetOf()
}