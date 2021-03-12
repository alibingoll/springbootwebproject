package com.moviesite.movieProject.repository;
import com.moviesite.movieProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    //Users findByUsername(String username);
    //User findByUsername(String username);
    User findByUserName(String username);
}
