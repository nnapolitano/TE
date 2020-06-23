package com.techelevator.entity;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class User {


    public static final String CUSTOMER_ROLE = "CUSTOMER";

    private Long id;

    private String role;

    @NotNull
    @Email
    private String getUserName;
    @Size(min = 10, message = "Password too short, must be at least 10")
    @Pattern.List({
            @Pattern(regexp = ".*[a-z].*", message = "Must have a lower case"),
            @Pattern(regexp = ".*[A-Z].*", message = "Must have a capital")
    })


    private String password;
    private String confirmPassword;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    public User(String getUserName) {
        this.getUserName = getUserName;
    }

    public User() {
        this.role = CUSTOMER_ROLE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the role
     */
    public String getRole() {

        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {

        this.role = role;
    }

    public String getGetUserName() {

        return getUserName;
    }

    public void setGetUserName(String getUserName) {

        this.getUserName = getUserName;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getConfirmPassword() {

        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {

        this.confirmPassword = confirmPassword;
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
}
