package com.moviesite.movieProject.service.interfaces;

import com.moviesite.movieProject.dto.MovieDto;
import com.moviesite.movieProject.model.Movie;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IMovieService {
    List<MovieDto> getMovies();
    MovieDto createdMovie(Movie movie,HttpServletRequest request);
    MovieDto updatedMovie(Long id,Movie movie,HttpServletRequest request);
    MovieDto getMovieById(Long id);
    MovieDto deleteMovieById(Long id,HttpServletRequest request);
}
