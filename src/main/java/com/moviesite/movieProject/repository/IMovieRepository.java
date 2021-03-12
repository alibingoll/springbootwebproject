package com.moviesite.movieProject.repository;

import com.moviesite.movieProject.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {
}
