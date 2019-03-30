package com.teo.store.model;

public class Location {
    private int id;
    private String name;
    private String city;
    private String country;

    public Location() {
        this.id = 0; this.name=""; this.city = ""; this.country = "";
    }

    public Location(int id, String name, String city, String country) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' + '}';
    }
}
