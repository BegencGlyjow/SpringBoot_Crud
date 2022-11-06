package com.example.demo.web.rest

import com.example.demo.dto.MovieDTO
import com.example.demo.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class MovieResource(
    private val  movieService: MovieService
) {
    @ExceptionHandler(IllegalArgumentException::class)
    fun exceptionHandler(exception: Exception):ResponseEntity<String>{
        return ResponseEntity(HttpStatus.BAD_REQUEST )
    }
    @PostMapping
    fun createMovie(@RequestBody movieDTO: MovieDTO):ResponseEntity<MovieDTO>{
        try {
        return ResponseEntity( movieService.createMovie(movieDTO),HttpStatus.CREATED)
        }
        catch (exeption:IllegalArgumentException){
            return ResponseEntity( null, HttpStatus.BAD_REQUEST)
        }
    }
}