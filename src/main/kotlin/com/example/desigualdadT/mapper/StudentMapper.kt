package com.example.desigualdadT.mapper

import com.example.desigualdadT.dto.StudentDto
import com.example.desigualdadT.entity.Student

object StudentMapper {

    fun toEntity(studentDto: StudentDto): Student {
        val student = Student()
        student.fullName = studentDto.fullName
        student.email = studentDto.email
        return student
    }
}