package com.teo.store.model;

import java.util.Date;

public class TheatrePlay extends Event {
    Boolean improvizatie;

    public TheatrePlay() {
    }

    public TheatrePlay(int id, String name, String smallDescription, Date startData, Date endDate, Location eventLocation, Boolean improvizatie) {
        super(id, name, smallDescription, startData, endDate, eventLocation);
        this.improvizatie = improvizatie;
    }
}
