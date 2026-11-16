package com.alpha.adminService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.adminService.Entity.Movie;

public interface addMovieRepo extends JpaRepository<Movie, Long> {

	public boolean existsByTitleIgnoreCaseAndLanguageIgnoreCase(String title, String language);

}
