package com.teo.store;

import com.teo.store.model.*;
import com.teo.store.services.AuditService;
import com.teo.store.services.CSVFileReader;
import com.teo.store.services.CSVFileWriter;
import com.teo.store.services.EventService;


import javax.swing.*;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static EventService eventService = EventService.getInstance();

    public static void main(String[] args) {
	// write your code here
        String[] filePath =
                {"C:\\Users\\Teodora\\Documents\\fmi\\ANUL 2\\semestrul2\\PAO\\OnlineTickets\\Files\\events.csv",
                        "C:\\Users\\Teodora\\Documents\\fmi\\ANUL 2\\semestrul2\\PAO\\OnlineTickets\\Files\\concerts.csv",
                        "C:\\Users\\Teodora\\Documents\\fmi\\ANUL 2\\semestrul2\\PAO\\OnlineTickets\\Files\\movies.csv",
                        "C:\\Users\\Teodora\\Documents\\fmi\\ANUL 2\\semestrul2\\PAO\\OnlineTickets\\Files\\plays.csv",
                        "C:\\Users\\Teodora\\Documents\\fmi\\ANUL 2\\semestrul2\\PAO\\OnlineTickets\\Files\\standups.csv",
                        "C:\\Users\\Teodora\\Documents\\fmi\\ANUL 2\\semestrul2\\PAO\\OnlineTickets\\Files\\newevents.csv"};

        CSVFileReader csvFileReader = CSVFileReader.getInstance();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                OnlineTicketsForm onlineTicketsForm = new OnlineTicketsForm();
                onlineTicketsForm.initalizeFrameWithMenu(onlineTicketsForm,eventService);

            }
        });

        AuditService auditService=AuditService.getInstance();
        for (String s : filePath) {
            csvFileReader.readFromFile(s, eventService);
           auditService.writeToFile("C:\\Users\\Teodora\\Documents\\fmi\\ANUL 2\\semestrul2\\PAO\\OnlineTickets\\Files\\audit.csv","read from " + s);
        }

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

                    CSVFileWriter csvFileWriter = CSVFileWriter.getInstance();
                    try {
                        csvFileWriter.writeToFile(filePath[5],newEvent);
                        auditService.writeToFile("C:\\Users\\Teodora\\Documents\\fmi\\ANUL 2\\semestrul2\\PAO\\OnlineTickets\\Files\\audit.csv","write from " + filePath[5]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    eventService.addEvent(newEvent);
                    newEvent=null;
                    break;
                }
                case 2: {
                    eventService.printAllEvents(eventService.getEventsList());
                    break;
                }
                case 3: {
                    eventService.printAll(eventService.getAllMovies());
                    break;
                }
                case 4: {
                    eventService.printAll(eventService.getAllConcerts());
                    break;
                }
                case 5: {
                    eventService.printAll(eventService.getAllStandUps());
                    break;
                }
                case 6: {
                    eventService.printAll(eventService.getAllTheatrePlays());
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
