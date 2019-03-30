package com.teo.store.model;

public class Ticket {
    private int id;
    private Event event;
    private double price;

    public Ticket(int id, Event event, double price) {
        this.id = id;
        this.event = event;
        this.price = price;
    }
}
