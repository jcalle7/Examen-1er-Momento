package com.example.desigualdadT.service

import com.example.desigualdadT.dto.StudentDto
import com.example.desigualdadT.dto.CommentDto
import com.example.desigualdadT.entity.Comment
import com.example.desigualdadT.entity.Student
import com.example.desigualdadT.mapper.StudentMapper
import com.example.desigualdadT.mapper.StudentMapper.toCommentDto
import com.example.desigualdadT.repository.StudentRegisteredViewRepository
import com.example.desigualdadT.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Description
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping

@Service
class StudentService {

    @Autowired
    lateinit var studentRepository: StudentRepository

    @Autowired
    lateinit var studentRegisteredViewRepository: StudentRegisteredViewRepository

    fun getStudents() : List<Student> {
        return studentRepository.findAll()
    }

    fun getStudentsFromView(): List<CommentDto> {
        val commentsFromView = studentRegisteredViewRepository.findAll()
        return commentsFromView.map { toCommentDto(it) }
    }

    fun save(studentDto: StudentDto): Student {
        val student = StudentMapper.toEntity(studentDto)
        return studentRepository.save(student)
    }

    @PostMapping("/students/{id}/comments")
    fun addComment(studentId: Long, description: String): Comment {
        val student = studentRepository.findById(studentId)
            .orElseThrow { IllegalArgumentException("Estudiante con ID $studentId no encontrado") }
        val comment = Comment().apply {
            this.description = description
            this.student = student
        }
        return studentRegisteredViewRepository.save(comment)
    }

    fun saveComment(studentId: Long, commentDto: CommentDto): Comment {
        val student = studentRepository.findById(studentId).orElseThrow {
            IllegalArgumentException("El estudiante con ID $studentId no existe.")
        }

        val comment = Comment().apply {
            description = commentDto.description
            courseName = commentDto.courseName
            this.student = student
        }

        return studentRegisteredViewRepository.save(comment)
    }


    fun getCommentsByStudent(studentId: Long): List<CommentDto> {
        val comments = studentRegisteredViewRepository.findByStudentId(studentId)
        return comments.map { toCommentDto(it) }
    }

}