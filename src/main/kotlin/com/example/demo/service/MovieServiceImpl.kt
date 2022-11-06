package com.example.demo.service

import com.example.demo.dto.MovieDTO
import com.example.demo.entity.Movie
import com.example.demo.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl(
    private  val movieRepository: MovieRepository,
) : MovieService {

    override fun getAll(): List<MovieDTO> {
        return movieRepository.findAll().map { it.toDto() }
    }

    private fun Movie.toDto():MovieDTO = MovieDTO(
        id = this.id,
        name = this.name,
        rating = this.rating
    )
}
