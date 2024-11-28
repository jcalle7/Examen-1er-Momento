package com.example.desigualdadT.controller

import com.example.desigualdadT.dto.CommentDto
import com.example.desigualdadT.dto.StudentDto
import com.example.desigualdadT.response.ApiResponse
import com.example.desigualdadT.service.StudentService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/students")
class SystemController {

    @Autowired
    lateinit var studentService: StudentService

    @GetMapping
    fun getStudents(): ResponseEntity<*> {
    return try {
        val students = studentService.getStudents()
        ResponseEntity.ok(ApiResponse(status = "success", data = students))
    } catch (e: Exception) {
        ResponseEntity(
            ApiResponse<Any>(status = "error", message = "Error al obtener los estudiantes"),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
    }

    @PostMapping
    fun save(@RequestBody @Valid studentDto: StudentDto): ResponseEntity<*> {
        return try {
            val savedStudent = studentService.save(studentDto)
            ResponseEntity(
                ApiResponse(status = "success", data = savedStudent, message = "Estudiante creado exitosamente"),
                HttpStatus.CREATED
            )
        } catch (e: IllegalArgumentException) {
            ResponseEntity(
                ApiResponse<Any>(status = "fail", message = "Datos inválidos: ${e.message}"),
                HttpStatus.BAD_REQUEST
            )
        } catch (e: Exception) {
            ResponseEntity(
                ApiResponse<Any>(status = "error", message = "Error al guardar el estudiante"),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    @GetMapping("/view")
    fun getStudentsView(): ResponseEntity<*> {
        return try {
            val viewData = studentService.getStudentsFromView()
            ResponseEntity.ok(ApiResponse(status = "success", data = viewData))
        } catch (e: Exception) {
            ResponseEntity(
                ApiResponse<Any>(status = "error", message = "Error al obtener los datos de la vista"),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }

    @PostMapping("/{studentId}/comments")
    fun saveComment(
        @PathVariable studentId: Long,
        @RequestBody @Valid commentDto: CommentDto
    ): ResponseEntity<*> {
        return try {
            val savedComment = studentService.saveComment(studentId, commentDto)
            ResponseEntity(
                ApiResponse(status = "success", data = savedComment, message = "Comentario guardado exitosamente"),
                HttpStatus.CREATED
            )
        } catch (e: IllegalArgumentException) {
            ResponseEntity(
                ApiResponse<Any>(status = "fail", message = "Datos inválidos: ${e.message}"),
                HttpStatus.BAD_REQUEST
            )
        } catch (e: Exception) {
            ResponseEntity(
                ApiResponse<Any>(status = "error", message = "Error al guardar el comentario"),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }

    }

    @GetMapping("/{studentId}/comments")
    fun getCommentsByStudent(@PathVariable studentId: Long): ResponseEntity<*> {
        return try {
            val comments = studentService.getCommentsByStudent(studentId)
            ResponseEntity.ok(ApiResponse(status = "success", data = comments))
        } catch (e: Exception) {
            ResponseEntity(
                ApiResponse<Any>(status = "error", message = "Error al obtener los comentarios"),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
}