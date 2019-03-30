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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", city='" + getCity() + '\'' +
                ", country='" + getCountry() + '\'' +
                '}';
    }
}
