package com.example.desigualdadT.repository

import com.example.desigualdadT.entity.StudentsRegisteredView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRegisteredViewRepository: JpaRepository<StudentsRegisteredView, Long>{
}