package com.example.desigualdadT.repository

import com.example.desigualdadT.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRegisteredViewRepository: JpaRepository<Comment, Long>{
    fun findByStudentId(studentID: Long) : List<Comment>
}