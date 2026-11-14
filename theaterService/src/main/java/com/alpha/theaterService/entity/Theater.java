package com.alpha.theaterService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "theaters")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String city;
    
    @Column(unique = true , nullable = false)
    private long contactNumber;
    @Column(unique = true, nullable = false)
    private String mailId;
    private int totalScreens;
    private String status;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", unique = true)
    private Address address;

    @OneToMany(mappedBy = "theater",
               cascade = CascadeType.ALL)
    private List<Show> allPlayingShows;

    // No-argument constructor
    public Theater() {
    }

    // Parameterized constructor
    public Theater(String name, String description,
            String city, long contactNumber, String mailId,
            int totalScreens, String status, Address address,
            List<Show> allPlayingShows) {

        this.name = name;
        this.description = description;
        this.city = city;
        this.contactNumber = contactNumber;
        this.mailId = mailId;
        this.totalScreens = totalScreens;
        this.status = status;
        this.address = address;
        this.allPlayingShows = allPlayingShows;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public int getTotalScreens() {
        return totalScreens;
    }

    public void setTotalScreens(int totalScreens) {
        this.totalScreens = totalScreens;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Show> getAllPlayingShows() {
        return allPlayingShows;
    }

    public void setAllPlayingShows(List<Show> allPlayingShows) {
        this.allPlayingShows = allPlayingShows;
    }
}

