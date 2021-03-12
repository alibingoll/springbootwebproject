package com.moviesite.movieProject.service;

import com.moviesite.movieProject.dto.MovieDto;
import com.moviesite.movieProject.exception.NotFoundException;
import com.moviesite.movieProject.model.Comments;
import com.moviesite.movieProject.model.Movie;
import com.moviesite.movieProject.model.User;
import com.moviesite.movieProject.repository.ICommentRepository;
import com.moviesite.movieProject.repository.IMovieRepository;
import com.moviesite.movieProject.repository.IUserRepository;
import com.moviesite.movieProject.service.interfaces.ICommentService;
import com.moviesite.movieProject.shared.LocalDateNow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public List<Comments> getComments() {
        //return movieRepository.findAll().stream().map(MovieDto::of).collect(Collectors.toList());
        return commentRepository.findAll();
    }

    @Override
    public Comments createdComment(Long id, User user,Comments comments) {
        //final User user=userRepository.findById(id).orElseThrow(()-> new NotFoundException("Kullanıcı Bulunamadı"));
        final Movie movie=movieRepository.findById(id).orElseThrow(()->new NotFoundException("Film Bulunamadı"));
        comments.setMovie(movie);
        comments.setUser(user);
        comments.setRegistrationDate(new LocalDateNow().now());
        commentRepository.save(comments);
        return comments;
    }

    @Override
    public Comments updatedComment(Long id,Comments comments) {
        //final Movie updateMovie=movieRepository.findById(id).orElseThrow(()->new NotFoundException("Film Bulunamadı"));
        final Comments updateComment=commentRepository.findById(id).orElseThrow(()-> new NotFoundException("Yorum bulunamadı"));
        updateComment.setComment(comments.getComment());
        commentRepository.save(updateComment);
        return updateComment;
    }

    @Override
    public Comments getCommentById(Long id) {
        return null;
    }

    @Override
    public Comments deleteComment(Long id) {
        return null;
    }
}
