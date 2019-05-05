package com.teo.store.model;

import java.util.Date;

public class Consumer {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Location address;
    private String email;


    public Consumer(String firstName, String lastName, Date birthDate, Location address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.email = email;
    }

    public Consumer() {
    }
}
