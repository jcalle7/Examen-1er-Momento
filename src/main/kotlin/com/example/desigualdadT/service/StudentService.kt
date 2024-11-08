package com.example.desigualdadT.service

import com.example.desigualdadT.dto.StudentDto
import com.example.desigualdadT.entity.Student
import com.example.desigualdadT.mapper.StudentMapper
import com.example.desigualdadT.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService {

    @Autowired
    lateinit var studentRepository: StudentRepository

    fun getStudents() : List<Student> {
        return studentRepository.findAll()
    }

    fun save(studentDto: StudentDto): Student {
        val student = StudentMapper.toEntity(studentDto)
        return studentRepository.save(student)
    }
}