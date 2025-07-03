package com.jhandai_padheko.model;

import java.time.LocalDate;

public class UserModel {

    private int user_id;
    private String firstName;
    private String lastName;
    private String username;
    private LocalDate dob;
    private String gender;
    private String email;
    private String password;
    private String phone;
    private String role;
    private String imagePath;

    public UserModel() {
    }

    // Full constructor
    public UserModel(int user_id, String firstName, String lastName, String username, LocalDate dob, String gender,
                     String email, String password, String phone, String imagePath) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.imagePath = imagePath; 
    }
 // Update User constructor
    public UserModel(int user_id, String firstName, String lastName, String username, LocalDate dob, String gender,
                     String email, String phone) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }
    
    // Update User constructor
    public UserModel(int user_id, String firstName, String lastName, String username, LocalDate dob, String gender,
                     String email, String password, String phone) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }


    // Constructor for login (username, password only)
    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Constructor for profile (no password)
    public UserModel(int user_id, String username, String gender, String email, String phone) {
        this.user_id = user_id;
        this.username = username;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    // Constructor for profile (with all details except imagePath)
    public UserModel(int user_id, String firstName, String lastName, String username, String gender, String email,
                     String phone) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    // Constructor called for registration (with imagePath)
    public UserModel(String firstName, String lastName, String username, LocalDate dob, String gender, String email,
                     String password, String phone, String imagePath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.imagePath = imagePath;  // Include imagePath
    }

    // Getters and setters for all fields

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
