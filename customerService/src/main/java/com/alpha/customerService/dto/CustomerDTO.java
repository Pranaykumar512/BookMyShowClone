
package com.alpha.customerService.dto;

public class CustomerDTO {

    private String name;

    private long phone;

    private String mail;

    private int age;

    private String gender;

    // No-argument constructor
    public CustomerDTO() {
    }

    // Parameterized constructor
    public CustomerDTO(String name, long phone, String mail,
                       int age, String gender) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.age = age;
        this.gender = gender;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
}
