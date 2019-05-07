package com.teo.store.model;

public class Ticket {
    private int id;
    private boolean VIP;
    private double price;
    private String seat;
    private Event event;
    private Consumer owner;

    public Ticket(int id, boolean VIP, double price, String seat, Event event, Consumer owner) {
        this.id = id;
        this.VIP = VIP;
        this.price = price;
        this.seat = seat;
        this.event = event;
        this.owner = owner;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Consumer getOwner() {
        return owner;
    }

    public void setOwner(Consumer owner) {
        this.owner = owner;
    }
}
