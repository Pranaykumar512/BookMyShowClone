package com.alpha.customerService.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String seatNo;

	private String showName;

	private String movieName;

	private int screenNo;

	private double totalAmount;

	private LocalDate date;

	private String language;

	private LocalDateTime bookingDate;

	@OneToOne
	private Customer customer;
	
	private long theaterId;
	
	// No-argument constructor
	public Ticket() {
	}

	// Parameterized constructor
	public Ticket(Long id, String username, String seatNo, String showName, String movieName, int screenNo,
			double totalAmount, LocalDate date, String language, LocalDateTime bookingDate, long theaterId) {

		this.id = id;
		this.username = username;
		this.seatNo = seatNo;
		this.showName = showName;
		this.movieName = movieName;
		this.screenNo = screenNo;
		this.totalAmount = totalAmount;
		this.date = date;
		this.language = language;
		this.bookingDate = bookingDate;
		this.theaterId = theaterId;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(long theaterId) {
		this.theaterId = theaterId;
	}
}
