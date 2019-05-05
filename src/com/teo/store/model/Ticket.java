package com.teo.store.model;

public class Ticket {
    private int id;
    private double price;
    private String seat;
    private Event event;
    private Consumer owner;

    public Ticket(int id, double price, String seat, Event event, Consumer owner) {
        this.id = id;
        this.price = price;
        this.seat = seat;
        this.event = event;
        this.owner = owner;
    }
}
