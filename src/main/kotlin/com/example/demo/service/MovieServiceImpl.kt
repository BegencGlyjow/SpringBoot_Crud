package com.example.demo.service

import com.example.demo.dto.MovieDTO
import com.example.demo.repository.MovieRepository
import com.example.demo.utils.mapper.MovieMapper
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl(
    private  val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) : MovieService {
    override fun createMovie(movieDTO: MovieDTO):MovieDTO {
        if(movieDTO.id != -1)
            throw IllegalArgumentException(" id -1")
        val movie = movieMapper.toEntity(movieDTO)
        movieRepository.save(movie)
        return  movieMapper.fromEntity(movie)
    }
}