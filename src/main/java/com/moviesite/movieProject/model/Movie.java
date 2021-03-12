package com.moviesite.movieProject.model;


import com.moviesite.movieProject.shared.LocalDateNow;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_title", length = 50,nullable = false)
    private String movieTitle;

    @Column(name = "movie_description", length = 1500,nullable = false)
    private String movieDescription;

    @Column(name = "small_photo_url", length = 1000)
    private String sPhotoUrl;

    @Column(name = "big_photo_url", length = 1000)
    private String bPhotoUrl;

    @Column(name = "registraiton_date",length = 30)
    private String registrationDate=new LocalDateNow().now();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    /*@ManyToOne
    @JoinColumn(name = "comments")
    private Comments comments;*/

}
