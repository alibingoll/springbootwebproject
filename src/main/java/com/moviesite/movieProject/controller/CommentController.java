package com.moviesite.movieProject.controller;


import com.moviesite.movieProject.dto.MovieDto;
import com.moviesite.movieProject.exception.NotFoundException;
import com.moviesite.movieProject.model.Comments;
import com.moviesite.movieProject.model.Movie;
import com.moviesite.movieProject.model.User;
import com.moviesite.movieProject.repository.IUserRepository;
import com.moviesite.movieProject.service.interfaces.ICommentService;
import com.moviesite.movieProject.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IUserRepository userRepository;

    @GetMapping(path = "/comments")
    public ResponseEntity<List<Comments>> getComments(){
        final List<Comments> comments=commentService.getComments();
        return ResponseEntity.ok(comments);
    }

    @PostMapping(path = "{id}/addcomment",consumes = "application/json", produces = "application/json")
    public ResponseEntity<Comments> createMovie(@PathVariable(value = "id") Long id, @RequestBody Comments comments){
        final User user=userRepository.findById(1L).orElseThrow(()-> new NotFoundException("Kullanıcı Bulunamadı"));
        commentService.createdComment(id,user,comments);
        return ResponseEntity.ok(comments);

    }

    @PutMapping(path = "/comment/{id}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateComment(@PathVariable(value = "id") Long id,@RequestBody Comments comments){
        //final MovieDto updatedMovieDto=movieService.updatedMovie(id,movie);
        commentService.updatedComment(id,comments);
        return ResponseEntity.ok(comments.getComment());

    }

}
