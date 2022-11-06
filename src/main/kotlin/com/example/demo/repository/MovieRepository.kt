package com.example.demo.repository

import com.example.demo.dto.MovieDTO
import com.example.demo.entity.Movie
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface MovieRepository:CrudRepository<Movie,Int>
