package com.alpha.adminService.Service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.adminService.Entity.Movie;
import com.alpha.adminService.Exception.MovieAlreadyExistException;
import com.alpha.adminService.Exception.MovieNotFoundException;
import com.alpha.adminService.Repository.addMovieRepo;
import com.alpha.adminService.ResponseStructure.ResponseStructure;
import com.alpha.adminService.dto.MovieRequestDTO;
import com.alpha.adminService.dto.MovieResponseDTO;

@Service
public class AdminService {
	
	@Autowired
	private addMovieRepo addMovieRepo;
	
	public ResponseEntity<ResponseStructure<MovieResponseDTO>> addMovieService(MovieRequestDTO dto) {
		ResponseStructure<MovieResponseDTO> rs= new ResponseStructure<MovieResponseDTO>();
		if(addMovieRepo.existsByTitleIgnoreCaseAndLanguageIgnoreCase(dto.getTitle(),dto.getLanguage())) {
			throw new MovieAlreadyExistException();
		}
		Movie movie=new Movie();
		movie.setTitle(dto.getTitle());
		movie.setDescription(dto.getDescription());
		movie.setCast(dto.getCast());
		movie.setLanguage(dto.getLanguage());
		
		Movie SaveMovie=addMovieRepo.save(movie);
		
		MovieResponseDTO movieResponseDTO=new MovieResponseDTO();
		movieResponseDTO.setMovieId(SaveMovie.getId());
		movieResponseDTO.setTitle(SaveMovie.getTitle());
		movieResponseDTO.setDescription(SaveMovie.getDescription());
		movieResponseDTO.setCast(SaveMovie.getCast());
		movieResponseDTO.setLanguage(SaveMovie.getLanguage());
		
		rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("Movie added successfully");
        rs.setData(movieResponseDTO);

        return new ResponseEntity<ResponseStructure<MovieResponseDTO>>(rs,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<MovieResponseDTO>> findMovieService(long id) {
		ResponseStructure<MovieResponseDTO> rs= new ResponseStructure<MovieResponseDTO>();
		Movie movie=addMovieRepo.findById(id).orElseThrow(()->new MovieNotFoundException());
		MovieResponseDTO movieResponseDTO=new MovieResponseDTO();
		movieResponseDTO.setMovieId(movie.getId());
		movieResponseDTO.setTitle(movie.getTitle());
		movieResponseDTO.setDescription(movie.getDescription());
		movieResponseDTO.setCast(movie.getCast());
		movieResponseDTO.setLanguage(movie.getLanguage());
		rs.setStatusCode(HttpStatus.FOUND.value());
        rs.setMessage("Movie Found");
        rs.setData(movieResponseDTO);

        return new ResponseEntity<ResponseStructure<MovieResponseDTO>>(rs,HttpStatus.FOUND);
		
	}

	public ResponseEntity<ResponseStructure<List<Movie>>> allMovieService() {
		ResponseStructure<List<Movie>> rs=new ResponseStructure<List<Movie>>(); 
		List<Movie> allMovie = addMovieRepo.findAll();
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage("sucess");
		rs.setData(allMovie);
		return new ResponseEntity<ResponseStructure<List<Movie>>>(rs,HttpStatus.FOUND);
		
	}

	public ResponseEntity<ResponseStructure<MovieResponseDTO>> deleteMoviebyId(long id) {
		ResponseStructure<MovieResponseDTO> rs= new ResponseStructure<MovieResponseDTO>();
		Movie movie=addMovieRepo.findById(id).orElseThrow(()->new MovieNotFoundException());
		MovieResponseDTO movieResponseDTO=new MovieResponseDTO();
		movieResponseDTO.setMovieId(movie.getId());
		movieResponseDTO.setTitle(movie.getTitle());
		movieResponseDTO.setDescription(movie.getDescription());
		movieResponseDTO.setCast(movie.getCast());
		movieResponseDTO.setLanguage(movie.getLanguage());
		addMovieRepo.deleteById(id);
		rs.setStatusCode(HttpStatus.FOUND.value());
        rs.setMessage("Movie Found and deleted");
        rs.setData(movieResponseDTO);

        return new ResponseEntity<ResponseStructure<MovieResponseDTO>>(rs,HttpStatus.FOUND);
		
	}

}
