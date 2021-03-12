package com.moviesite.movieProject.service;

import com.moviesite.movieProject.dto.MovieDto;
import com.moviesite.movieProject.exception.NotFoundException;
import com.moviesite.movieProject.model.Movie;
import com.moviesite.movieProject.model.User;
import com.moviesite.movieProject.repository.IMovieRepository;
import com.moviesite.movieProject.repository.IUserRepository;
import com.moviesite.movieProject.service.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private IUserRepository userRepository;




    @Override
    public List<MovieDto> getMovies() {
       return movieRepository.findAll().stream().map(MovieDto::of).collect(Collectors.toList());
    }

    @Override
    public MovieDto createdMovie(Movie movie,HttpServletRequest request) {
        //final User user=userRepository.findById(id).orElseThrow(()-> new NotFoundException("Kullanıcı Bulunamadı"));
        try {
            HttpSession session=request.getSession(false);
            String uName=(String)session.getAttribute("uname");
            final User user=userRepository.findByUserName(uName);
            movie.setUser(user);
            movieRepository.save(movie);
            return MovieDto.of(movie);
        }catch (Exception e){
            System.out.println("Hata Giriş yapmamış olabilirsiniz.");
        }
        return null;
    }

    @Override
    public MovieDto updatedMovie(Long id, Movie movie,HttpServletRequest request) {
        try {
            HttpSession session=request.getSession();
            final Movie updateMovie=movieRepository.findById(id).orElseThrow(()->new NotFoundException("Film Bulunamadı"));
            String uName=(String)session.getAttribute("uname");
            final User user=userRepository.findByUserName(uName);
            if (user.getUserName().equals(updateMovie.getUser().getUserName())) {
                updateMovie.setMovieTitle(movie.getMovieTitle());
                updateMovie.setMovieDescription(movie.getMovieDescription());
                updateMovie.setBPhotoUrl(movie.getBPhotoUrl());
                updateMovie.setSPhotoUrl(movie.getSPhotoUrl());
                movieRepository.save(updateMovie);
                return MovieDto.of(updateMovie);
            }
            else {
                System.out.println("Bu Filmi düzenleyemezsiniz.");
            }
        }catch (Exception e)
        {
            System.out.println("Hata Giriş yapmamış olabilirsiniz.");
        }
        return null;
    }

    @Override
    public MovieDto getMovieById(Long id) {
        final Movie movie=movieRepository.findById(id).orElseThrow(()->new NotFoundException("Film Bulunamadı"));

        return MovieDto.of(movie);
    }

    @Override
    public MovieDto deleteMovieById(Long id,HttpServletRequest request) {
        try{
            HttpSession session=request.getSession();
            final Movie movie=movieRepository.findById(id).orElseThrow(()->new NotFoundException("Film Bulunamadı"));
            String uName=(String)session.getAttribute("uname");
            final User user=userRepository.findByUserName(uName);
            if (user.getUserName().equals(movie.getUser().getUserName()))
            {
                movieRepository.deleteById(movie.getId());
                return MovieDto.of(movie);
            }else {
                System.out.println("Bu kullanıcı bu filmi silemez");
            }

        }catch (Exception e){
            System.out.println("Hata Giriş yapmamış olabilirsiniz.");
        }
    return null;
    }
}
