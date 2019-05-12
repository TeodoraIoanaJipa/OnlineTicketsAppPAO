package com.teo.store.model;

public class Ticket {
    private int id;
    private boolean VIP;
    private double price;
    private double priceVIP;
    private String seat;
    private Event event;
    private Consumer owner;

    public Ticket(int id, boolean VIP, double price, double priceVIP, String seat, Event event, Consumer owner) {
        this.id = id;
        this.VIP = VIP;
        this.price = price;
        this.priceVIP = priceVIP;
        this.seat = seat;
        this.event = event;
        this.owner = owner;
    }

    public Ticket() {
    }

    public double getPriceVIP() {
        return priceVIP;
    }

    public void setPriceVIP(double priceVIP) {
        this.priceVIP = priceVIP;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", VIP=" + VIP +
                ", price=" + price +
                ", priceVIP=" + priceVIP +
                ", seat='" + seat + '\'' +
                ", event=" + event +
                ", owner=" + owner +
                '}';
    }
}
