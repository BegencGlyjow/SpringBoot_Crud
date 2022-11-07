package com.example.demo.controller

import com.example.demo.dto.MovieDTO
import com.example.demo.service.MovieService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/movies")
class MovieController(
    private val movieService: MovieService
) {
   @GetMapping
   fun getAll(@RequestParam("page") pageIndex:Int):List<MovieDTO> = movieService.getAll(pageIndex)

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id:Int):MovieDTO =
        movieService.getById(id)

    @GetMapping("search")
    fun searchMovie(@RequestParam("prefix") prefix:String):List<MovieDTO> =
        movieService.searchMovie(prefix)

    @PostMapping
    fun create(@RequestBody dto: MovieDTO):Int {
            return movieService.create(dto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: MovieDTO) {
            return movieService.update(id,dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int){
        return movieService.delete(id)
    }
}