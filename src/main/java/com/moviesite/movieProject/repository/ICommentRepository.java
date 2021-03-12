package com.moviesite.movieProject.repository;

import com.moviesite.movieProject.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comments,Long> {
}
