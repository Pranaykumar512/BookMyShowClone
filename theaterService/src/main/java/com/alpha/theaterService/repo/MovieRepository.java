package com.alpha.theaterService.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.theaterService.entity.Movie;

public interface MovieRepository
        extends JpaRepository<Movie, Long> {

}
