package com.moviesite.movieProject.controller;

import com.moviesite.movieProject.dto.MovieDto;
import com.moviesite.movieProject.dto.UserCreatedDto;
import com.moviesite.movieProject.model.Movie;
import com.moviesite.movieProject.service.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping(path = "/movies")
    public ResponseEntity<List<MovieDto>> getMovies(){
        final List<MovieDto> movies=movieService.getMovies();
        return ResponseEntity.ok(movies);
    }

    @PostMapping(path = "/addmovie",consumes = "application/json", produces = "application/json")
    public ResponseEntity<MovieDto> createMovie(@RequestBody Movie movie, HttpServletRequest request){
        MovieDto createdMovie=movieService.createdMovie(movie,request);
        return ResponseEntity.ok(createdMovie);

    }

    @PutMapping(path = "/movie/{id}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable(value = "id") Long id,@RequestBody Movie movie,HttpServletRequest request){
        final MovieDto updatedMovieDto=movieService.updatedMovie(id,movie,request);
        return ResponseEntity.ok(updatedMovieDto);

    }

    @ReadOnlyProperty
   @GetMapping(path = "/movie/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable(value = "id") Long id){
        final MovieDto movieDto=movieService.getMovieById(id);
        return ResponseEntity.ok(movieDto);
   }

   @DeleteMapping(path = "/movie/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable(value = "id") Long id,HttpServletRequest request)
   {

       MovieDto deletedMovie=movieService.deleteMovieById(id,request);
       return ResponseEntity.ok(deletedMovie);
   }



}
