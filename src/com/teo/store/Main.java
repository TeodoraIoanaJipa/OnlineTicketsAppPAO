package com.teo.store;

import com.teo.store.model.*;
import com.teo.store.services.EventService;

import java.util.Date;
import java.util.Scanner;

public class Main {

    private static EventService eventService = EventService.getInstance();

    public static void main(String[] args) {
	// write your code here

        Date bondate=new Date(2019,8,21);

        Event firstEvent = new Concert(1,"Bon Jovi Concert", "Bon Jovi in concert la Sala Palatului This House is not For Sale Tour 2019",
                bondate,bondate,new Location(1,"Sala Palatului","Bucuresti","Romania"),new String[]{"Bon Jovi"});
        Event secondEvent = new Movie(2,"Bohemiam Rhapsody", "Rami Malek playes Freddie Mercury",
                bondate,bondate,new Location(2, "Cinema City","Bucuresti", "Romania"),new String[]{"Drama","Muzical","Biografic"});
        Event tEvent = new StandUpShow(3,"Hai sa razi!", "Hai in Mojo Club sa razi!",
                bondate,bondate,new Location(3, "Mojo Club","Bucuresti", "Romania"),new String[]{"Maria Popovici","Banciu","Manciu"});
        eventService.addEvent(firstEvent);
        eventService.addEvent(secondEvent);
        eventService.addEvent(tEvent);
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose an option: ");
            System.out.println("Type 0 for EXIT ");
            System.out.println("Type 1 if you want to add an Event ");
            System.out.println("Type 2 if you want to print all the Events ");
            System.out.println("Type 3 if you want to print all the Movies available");
            System.out.println("Type 4 if you want to print all the Concerts available");
            System.out.println("Type 5 if you want to print all the StandUp Shows available");

            int option = scanner.nextInt();

            switch (option){
                case 0:{
                    return;
                }
                case 1:{
                    System.out.println("What kind of Event do nyou want to add?");
                    System.out.println("Type 1 if you want to add Concert ");
                    System.out.println("Type 2 if you want to add Movie ");
                    System.out.println("Type 3 if you want to add StandUpShow");
                    System.out.println("Type 4 if you want to add TheatrePlay");
                    int chosen=scanner.nextInt();
                    Event newEvent;

                    switch (chosen){
                        case 1: newEvent=new Concert();
                        case 2: newEvent=new Movie();
                        case 3: newEvent=new StandUpShow();
                        case 4: newEvent=new TheatrePlay();
                        default: newEvent=new Event();
                    }
                    newEvent.makeNewEvent();
                    eventService.addEvent(newEvent);
                }
                case 2: {
                    eventService.printAllEvens();
                    break;
                }
            }
        }



    }
}
