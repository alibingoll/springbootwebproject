package com.moviesite.movieProject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment", length = 1500)
    private String comment;

    @Column(name = "registraiton_date",length = 50)
    private String registrationDate;//=LocalDate.now()

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
