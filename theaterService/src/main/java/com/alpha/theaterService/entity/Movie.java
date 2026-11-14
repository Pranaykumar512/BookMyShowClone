package com.alpha.theaterService.entity;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Column(name = "cast_members")
    private String cast;

    private double duration;

    @ElementCollection
    @CollectionTable(
        name = "movie_languages",
        joinColumns = @JoinColumn(name = "movie_id")
    )
    @Column(name = "language")
    private List<String> languages;

    // No-argument constructor
    public Movie() {
    }

    // Parameterized constructor
    public Movie(Long id, String title, String description,
            String cast, double duration, List<String> languages) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.cast = cast;
        this.duration = duration;
        this.languages = languages;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}

