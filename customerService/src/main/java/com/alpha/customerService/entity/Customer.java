
package com.alpha.customerService.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String mail;

    private Long phone;  // Changed from String to Long

    private int age;

    private String gender;

    @OneToMany(mappedBy = "customer",
               cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public Customer() {
    }

    public Customer(Long id, String name, String mail,
                    Long phone, int age, String gender,
                    List<Ticket> tickets) {

        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
        this.tickets = tickets;
    }

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
