package com.example.demo.service

import com.example.demo.dto.MovieDTO

interface MovieService {

    fun getAll(pageIndex: Int):List<MovieDTO>

    fun getById(id:Int):MovieDTO

    fun searchMovie(prefix:String):List<MovieDTO>

    fun create(dto: MovieDTO):Int

    fun update(id: Int,dto: MovieDTO)

    fun delete(id: Int)
}