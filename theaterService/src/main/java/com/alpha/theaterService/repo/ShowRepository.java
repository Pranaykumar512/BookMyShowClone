package com.alpha.theaterService.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.theaterService.entity.Show;

public interface ShowRepository
        extends JpaRepository<Show, Long> {

}
