package com.teo.store.services;

import com.teo.store.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventService {

    private List<Event> eventsList;

    private static EventService ourInstance = new EventService();

    public static EventService getInstance() {
        return ourInstance;
    }

    private EventService() {
        eventsList=new ArrayList<>();
    }

    public void addEvent(Event event){
        try {
            eventsList.add(event);
        }catch(NullPointerException ex){
            ex.getStackTrace();
        }
    }

    public void printAllEvens(){
        int nr=0;
        for (Event event : eventsList) {
            System.out.println(++nr +". " + event.toString());
        }
    }
}
