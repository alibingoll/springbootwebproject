package com.moviesite.movieProject.dto;

import com.moviesite.movieProject.model.Movie;
import com.moviesite.movieProject.model.User;

import lombok.Getter;


import java.io.Serializable;

@Getter
public class MovieDto implements Serializable {
    private static final long serialVersionUID=1L;

    private String movieTitle;
    private String movieDescription;
    private String registrationDate;
    private String bPhotoUrl;
    private String sPhotoUrl;
    private User user;




    private MovieDto(String movieTitle,String movieDescription,String registrationDate,String bPhotoUrl,String sPhotoUrl,User user){

        this.movieTitle=movieTitle;
        this.movieDescription=movieDescription;
        this.registrationDate=registrationDate;
        this.bPhotoUrl=bPhotoUrl;
        this.sPhotoUrl=sPhotoUrl;
        this.user=user;

    }
    public static MovieDto of(Movie movie){

        return new MovieDto(movie.getMovieTitle(),
                movie.getMovieDescription(),movie.getRegistrationDate(),movie.getBPhotoUrl(), movie.getSPhotoUrl(),movie.getUser());
    }
}
