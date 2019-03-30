package com.teo.store;

import com.teo.store.model.*;
import com.teo.store.services.EventService;

import java.util.Date;
import java.util.Scanner;

public class Main {

    private static EventService eventService = EventService.getInstance();

    public static void main(String[] args) {
	// write your code here

        Date bondate=new Date(2019,8,27);

        Event firstEvent = new Concert(1,"Bon Jovi Concert", "Bon Jovi in concert la Sala Palatului This House is not For Sale Tour 2019",
                bondate,new Date(2019,1,22),new Location(1,"Sala Palatului","Bucuresti","Romania"),new String[]{"Bon Jovi"});
        Event secondEvent = new Movie(2,"Bohemiam Rhapsody", "Rami Malek playes Freddie Mercury",
                bondate,bondate,new Location(2, "Cinema City","Bucuresti", "Romania"),new String[]{"Drama","Muzical","Biografic"});
        Event event3 = new StandUpShow(3,"Hai sa razi!", "Hai in Mojo Club sa razi!",
                bondate,bondate,new Location(3, "Mojo Club","Valencia", "Spania"),new String[]{"Maria Popovici","Banciu","Manciu"});
        Event event4 = new TheatrePlay(4,"O femeie singura", "Andreea Bibiri - castigatoarea premiului Cea mai buna interpretare feminina la Festivalul National de Teatru Galati",
                new Date(30, 5,2019),bondate,new Location(5,"Teatrul de Arta","Iasi","Romania"),false);
        Event event5 = new TheatrePlay(4,"O femeie singura", "Andreea Bibiri - castigatoarea premiului Cea mai buna interpretare feminina la Festivalul National de Teatru Galati",
                new Date(30, 5,2019),bondate,new Location(5,"Teatrul de Arta","Iasi","Romania"),false);
        eventService.addEvent(firstEvent);
        eventService.addEvent(secondEvent);
        eventService.addEvent(event3);
        eventService.addEvent(event4);

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose an option: ");
            System.out.println("Type 0 for EXIT ");
            System.out.println("Type 1 if you want to add an event ");
            System.out.println("Type 2 if you want to print all the events ");
            System.out.println("Type 3 if you want to print all the Movies available");
            System.out.println("Type 4 if you want to print all the Concerts available");
            System.out.println("Type 5 if you want to print all the StandUp Shows available");
            System.out.println("Type 6 if you want to print all the Theatre Plays available");
            System.out.println("Type 7 if you want to print all the events from a certain country");
            System.out.println("Type 8 if you want to print all the events from a certain city");

            int option = scanner.nextInt();

            switch (option){
                case 0:{
                    return;
                }
                case 1:{
                    System.out.println("What kind of Event do you want to add?");
                    System.out.println("Type 1 if you want to add Concert ");
                    System.out.println("Type 2 if you want to add Movie ");
                    System.out.println("Type 3 if you want to add StandUpShow");
                    System.out.println("Type 4 if you want to add TheatrePlay");

                    int chosen=scanner.nextInt();
                    Event newEvent;

                    switch (chosen){
                        case 1: {newEvent=new Concert(); break;}
                        case 2: {newEvent=new Movie(); break;}
                        case 3: {newEvent=new StandUpShow(); break;}
                        case 4: {newEvent=new TheatrePlay(); break;}
                        default:{ newEvent=new Event();}
                    }
                    newEvent.makeNewEvent();
                    eventService.addEvent(newEvent);
                    break;
                }
                case 2: {
                    eventService.printAllEvents(eventService.getEventsList());
                    break;
                }
                case 3: {
                    eventService.printAllMovies(eventService.getAllMovies());
                    break;
                }
                case 4: {
                    eventService.printAllConcerts(eventService.getAllConcerts());
                    break;
                }
                case 5: {
                    eventService.printAllstandUps(eventService.getAllStandUps());
                    break;
                }
                case 6: {
                    eventService.printAllTheatrePlays(eventService.getAllTheatrePlays());
                    break;
                }
                case 7: {
                    System.out.println("country: ");
                    String country = scanner.next();
                    eventService.printAllEvents(eventService.getEventsListByCountry(country.toLowerCase()));
                    break;
                }
                case 8: {
                    System.out.println("city: ");
                    String city = scanner.next();
                    eventService.printAllEvents(eventService.getEventsListByCity(city.toLowerCase()));
                    break;
                }
                default: {
                    System.out.println("Try entering a valid number");
                }
            }
        }



    }
}
