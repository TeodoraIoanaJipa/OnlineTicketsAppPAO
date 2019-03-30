package com.teo.store.model;

import java.util.Arrays;
import java.util.Date;

public class Movie extends Event {

    private String[] type;

    public Movie() {
    }

    public Movie(int id, String name, String smallDescription, Date startData, Date endDate, Location eventLocation, String[] type) {
        super(id, name, smallDescription, startData, endDate, eventLocation);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Movie{" + "type=" + Arrays.toString(type) + '}' + "\n" + super.toString();
    }
}
