package com.teo.store;

import com.teo.store.model.*;
import com.teo.store.model.Event;
import com.teo.store.services.ConsumerInfoForm;
import com.teo.store.services.EventService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OnlineTicketsForm {
    private EventService eventService = EventService.getInstance();
    private JPanel mainPanel;
    private JList<Event> list = new JList<>();
    private JFrame jFrame;
    private JButton cumparaBileteCinemaButton;
    private JButton cumparaBileteTeatruButton;
    private JButton cumparaBileteStandUpButton;
    private JButton cumparaBileteConcertButton;
    private JList list1;
    private JList list2;
    private JList list3;
    private JList list4;


    public OnlineTicketsForm() {
        cumparaBileteConcertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsumerInfoForm consumerInfoForm = new ConsumerInfoForm();
                consumerInfoForm.initalizeFrameWithMenu(eventService);

            }
        });
    }
    private void setModels(List<? extends Event> eventsList,JList<Event> list, OnlineTicketsForm onlineTicketsForm){
        DefaultListModel<Event> modelEvent = new DefaultListModel<>();
        list.setModel(modelEvent);
        for (Event ev : eventsList) {
            modelEvent.addElement(ev);
        }
    }

    private void initializePanels(OnlineTicketsForm onlineTicketsForm){

        JPanel panel = onlineTicketsForm.mainPanel;
        JSplitPane splitPane = new JSplitPane();

        List<Event> eventsList = eventService.getEventsList();
        setModels(eventsList,onlineTicketsForm.list,onlineTicketsForm);

        List<Concert> concertList = eventService.getAllConcerts();
        setModels(concertList,onlineTicketsForm.list1,onlineTicketsForm);

        List<StandUpShow> standUpList = eventService.getAllStandUps();
        setModels(standUpList,onlineTicketsForm.list2,onlineTicketsForm);

        List<Movie> moviesList = (List<Movie>) eventService.getAllMovies();
        setModels(moviesList,onlineTicketsForm.list3,onlineTicketsForm);

        List<TheatrePlay> playsList = (List<TheatrePlay>) eventService.getAllTheatrePlays();
        setModels(playsList,onlineTicketsForm.list4,onlineTicketsForm);

        JScrollPane jScrollPane = new JScrollPane(list);
        jScrollPane.createVerticalScrollBar();
        jScrollPane.setMinimumSize(new Dimension(400, 400));
        splitPane.setLeftComponent(jScrollPane);
        panel.setMinimumSize(new Dimension(400, 400));
        splitPane.setRightComponent(panel);

        jFrame.add(splitPane);

    }

    public void initalizeFrameWithMenu(OnlineTicketsForm onlineTicketsForm, EventService eventService){
        jFrame = new JFrame("Buy Online Tickets");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setMinimumSize(new Dimension(700,600));
        jFrame.setMaximumSize(new Dimension(700,600));
        jFrame.setPreferredSize(new Dimension(600,600));

        initializePanels(onlineTicketsForm);
        JMenuBar jMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Choose");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(exitMenuItem);
        jMenuBar.add(fileMenu);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
