package org.launchcode.spaday.models;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    // bonus id field
    private int id;
//    private static AtomicInteger idSequence = new AtomicInteger();
    private static int nextId =1;
    private String username;
    private String password;
    private String email;
    //bonus
    private final Date date;


    public User(String username, String password, String email) {
//        this.id =idSequence.incrementAndGet(); // bonus
        //this();
        this.id = nextId;
        nextId++;
        this.username = username;
        this.password = password;
        this.email = email;
        //bonus date
        this.date = new Date();


    }
    // bonus id
    public int getId(){ // bonus
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // bonus


    public Date getDate() {
        return date;
    }
}
