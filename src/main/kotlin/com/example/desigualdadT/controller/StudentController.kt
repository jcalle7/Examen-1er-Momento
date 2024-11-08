package com.example.desigualdadT.controller

import com.example.desigualdadT.dto.StudentDto
import com.example.desigualdadT.entity.Student
import com.example.desigualdadT.response.ApiResponse
import com.example.desigualdadT.service.StudentService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/student")
class StudentController {

    @Autowired
    lateinit var studentService: StudentService

    @GetMapping
    fun getStudents(): ResponseEntity<ApiResponse<List<Student>>> {
        val students = studentService.getStudents()
        val response = ApiResponse(status = "success", data = students)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody @Valid studentDto: StudentDto): ResponseEntity<ApiResponse<Student>> {
        val savedStudent = studentService.save(studentDto)
        val response = ApiResponse(status = "success", data = savedStudent, message = "Estudiante creado exitosamente")
        return ResponseEntity(response, HttpStatus.CREATED)
    }
}