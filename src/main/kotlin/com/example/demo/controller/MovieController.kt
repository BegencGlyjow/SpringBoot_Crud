package com.example.demo.controller

import com.example.demo.dto.MovieDTO
import com.example.demo.service.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/movies")
class MovieController(
    private val movieService: MovieService
) {
   @GetMapping
   fun getAll():List<MovieDTO> = movieService.getAll()
}