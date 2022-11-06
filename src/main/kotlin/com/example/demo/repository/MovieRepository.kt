package com.example.demo.repository

import com.example.demo.dto.MovieDTO
import com.example.demo.entity.entity.Movie
import org.springframework.data.repository.CrudRepository

interface MovieRepository:CrudRepository<Movie,Int> {
//    fun createMovie(movieDTO: MovieDTO)
//    fun getMovie(id:Int)
}