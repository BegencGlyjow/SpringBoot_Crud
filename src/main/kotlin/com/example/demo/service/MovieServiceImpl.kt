package com.example.demo.service

import com.example.demo.dto.MovieDTO
import com.example.demo.entity.Movie
import com.example.demo.repository.MovieRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl(
    private  val movieRepository: MovieRepository,
) : MovieService {

    override fun create(dto: MovieDTO): Int {
       return movieRepository.save(dto.toEntity()).id
    }

    override fun update(id: Int, dto: MovieDTO) {
       val existingMovie =  movieRepository.findByIdOrNull(id)
            ?:throw RuntimeException("")

        existingMovie.name = dto.name
        existingMovie.rating = dto.rating

        movieRepository.save(existingMovie)
    }

    override fun delete(id: Int) {
        val existingMovie =  movieRepository.findByIdOrNull(id)
            ?:throw RuntimeException("")

        movieRepository.deleteById(existingMovie.id )
    }

    override fun getAll(pageIndex:Int): List<MovieDTO> {
        return movieRepository.findByOrderByName(PageRequest.of(pageIndex, 2)).map { it.toDto() }
    }

    override fun getById(id: Int): MovieDTO {
        return movieRepository.findByIdOrNull(id)
            ?.toDto()
            ?:throw  RuntimeException("Movies not found")
    }

    override fun searchMovie(prefix: String): List<MovieDTO> =
        movieRepository.findByNameStartsWithIgnoreCaseOrderByName(prefix)
            .map { it.toDto()

            }


    private fun Movie.toDto():MovieDTO = MovieDTO(
        id = this.id,
        name = this.name,
        rating = this.rating
    )

    private  fun MovieDTO.toEntity():Movie = Movie(
        id = 0,
        name = this.name,
        rating = this.rating
    )
}
