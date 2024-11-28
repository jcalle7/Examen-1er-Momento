package com.example.desigualdadT.mapper

import com.example.desigualdadT.dto.CommentDto
import com.example.desigualdadT.dto.StudentDto
import com.example.desigualdadT.entity.Comment
import com.example.desigualdadT.entity.Student

object StudentMapper {

    fun toEntity(studentDto: StudentDto): Student {
        val student = Student()
        student.id = student.id
        student.fullName = studentDto.fullName
        student.email = studentDto.email
        student.phone = studentDto.phone
        student.address = studentDto.address
        return student
    }

    fun toDto(student: Student): StudentDto {
        return StudentDto().apply {
            id = student.id
            fullName = student.fullName
            email = student.email
            phone = student.phone
            address = student.address
        }
    }

    fun toCommentDto(comment: Comment): CommentDto {
        return CommentDto(
            id = comment.id,
            description = comment.description?:"Descripción no disponible",
            courseName = comment.courseName?: "Nombre del curso no disponible",
            studentId = comment.student?.id
        )
    }

    fun toCommentEntity(commentDto: CommentDto): Comment {
        val comment = Comment()
        comment.id = commentDto.id
        comment.description = commentDto.description
        return comment
    }
}