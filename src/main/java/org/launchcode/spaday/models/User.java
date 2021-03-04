package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {
    @NotNull
    @NotEmpty(message = "name required")
    @Size(min=3, max=15 ,message = "name size must be between 3 and 15")
    private String username;

    @NotNull
    @NotEmpty(message = "email required")
    @Email
    private String email;

    @NotNull
    @NotEmpty(message = "password must be required")
    @Size(min=3,max=6,message = "Password must be 6 characters long")
    private String password;

//    private String verify;
    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
