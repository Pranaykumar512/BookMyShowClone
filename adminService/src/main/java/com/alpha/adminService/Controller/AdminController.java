package com.alpha.adminService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.adminService.Entity.Movie;
import com.alpha.adminService.ResponseStructure.ResponseStructure;
import com.alpha.adminService.Service.AdminService;
import com.alpha.adminService.dto.MovieRequestDTO;
import com.alpha.adminService.dto.MovieResponseDTO;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin/addMovie")
	public ResponseEntity<ResponseStructure<MovieResponseDTO>> addMovie(@RequestBody MovieRequestDTO dto) {
		return adminService.addMovieService(dto);
	}
	
	@GetMapping("/movie/findMovie")
	public ResponseEntity<ResponseStructure<MovieResponseDTO>> findMovieById(@RequestParam long id) {
		return adminService.findMovieService(id);
	}
	
	@GetMapping("/movie/getAllMovie")
	public ResponseEntity<ResponseStructure<List<Movie>>> getAllMovie() {
		return adminService.allMovieService();
	}
	
	@DeleteMapping("/movie/delete")
	public ResponseEntity<ResponseStructure<MovieResponseDTO>> deleteMoviebyId(@RequestParam long id) {
		 return adminService.deleteMoviebyId(id);
	}
}
