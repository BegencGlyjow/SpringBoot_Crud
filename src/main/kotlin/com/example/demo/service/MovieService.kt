package com.example.demo.service

import com.example.demo.dto.MovieDTO

interface MovieService {

    fun getAll():List<MovieDTO>
}