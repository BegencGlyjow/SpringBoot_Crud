package com.example.demo.repository

import com.example.demo.entity.Movie
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.CrudRepository

interface MovieRepository:CrudRepository<Movie,Int>{
    fun findByOrderByName(pageable: PageRequest):List<Movie>

    fun findByNameStartsWithIgnoreCaseOrderByName(prefix:String):List<Movie>
}
