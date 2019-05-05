package com.teo.store.model;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

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

    public void makeNewEvent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of types of the movie (Drama, Thriller, Comedy, Science Fiction):");
        int numberOfTypes = scanner.nextInt();
        type=new String[numberOfTypes];
        for(int i=0;i<numberOfTypes;i++)
            this.type[i]=scanner.nextLine();
        super.makeNewEvent();
    }
}
