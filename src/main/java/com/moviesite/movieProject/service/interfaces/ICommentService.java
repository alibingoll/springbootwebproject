package com.moviesite.movieProject.service.interfaces;

import com.moviesite.movieProject.dto.MovieDto;
import com.moviesite.movieProject.model.Comments;
import com.moviesite.movieProject.model.Movie;
import com.moviesite.movieProject.model.User;

import java.util.List;

public interface ICommentService {
    List<Comments> getComments();
    Comments createdComment(Long id, User user,Comments comments);
    Comments updatedComment(Long id,Comments comments);
    Comments getCommentById(Long id);
    Comments deleteComment(Long id);
}
