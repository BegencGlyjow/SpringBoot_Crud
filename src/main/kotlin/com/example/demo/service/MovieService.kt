package com.example.demo.service

import com.example.demo.dto.MovieDTO

interface MovieService {
    fun createMovie(movieDTO: MovieDTO):MovieDTO
}