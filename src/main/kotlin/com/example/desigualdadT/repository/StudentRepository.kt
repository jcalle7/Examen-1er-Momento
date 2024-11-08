package com.example.desigualdadT.repository

import com.example.desigualdadT.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: JpaRepository<Student, Long> {
}