package com.teo.store.services;

import com.teo.store.OnlineTicketsForm;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ConsumerInfoForm {
    private JPanel userPanel;
    private JPanel jPanel1 = new JPanel();
    private JLabel jLabel2= new JLabel();
    private JLabel jLabelDate = new JLabel();
    private JLabel jLabelNume = new JLabel();
    private JLabel jLabelPrenume = new JLabel();
    private JSplitPane mySplitPane;
    private JRadioButton biletFilmRadioButton;
    private JTextField textFieldNume;
    private JSpinner jSpinnerZi;
    private JSpinner jSpinnerYear;
    private JFrame jFrame;

    public void setTextandSize(JLabel jLabel,String text,int width,JPanel myjPanel){
        jLabel.setPreferredSize(new Dimension(width,30));
        jLabel.setText(text);
        myjPanel.add(jLabel);
    }

    public void makeComboBox(JPanel jPanel, String[] items){
        JComboBox<String> jComboBox = new JComboBox<>();
        for(String month:items)
            jComboBox.addItem(month);
        jComboBox.setPreferredSize(new Dimension(80,27));
        jPanel.add(jComboBox);
    }

    public void makeLocation(JPanel jPanel){
        String[] towns = {"Alba Iulia","Arad","Braila","Bucuresti","Buzau","Bacau","Brasov","Cluj","Constanta","Iasi","Targu Mures","Timisoara"};
        makeComboBox(jPanel,towns);

        String[] countries = {"Bulgaria","Italia","Romania","Spania","Ungaria"};
        makeComboBox(jPanel,countries);
    }

    public void putTextFields(){
        JPanel jPanel = new JPanel();
        jPanel.setSize(new Dimension(270,500));
        jPanel.setPreferredSize(new Dimension(280,500));
        jPanel.setMaximumSize(new Dimension(280,500));
        jPanel.setMinimumSize(new Dimension(280,500));

        setTextandSize(jLabelDate,"Introduceti datele dumneavoastra\n\n\n",220,jPanel);

        setTextandSize(jLabelNume,"Nume:",60,jPanel);

        JTextField jNume = new JTextField("Ionescu",17);
        jNume.setPreferredSize(new Dimension(110,27));
        jPanel.add(jNume);
        jNume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = jNume.getText();
            }
        });

        setTextandSize(jLabelPrenume,"Prenume:",60,jPanel);

        JTextField jPrenume = new JTextField("Marius",17);
        jPrenume.setPreferredSize(new Dimension(110,27));

        jPanel.add(jPrenume);
        jPrenume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = jPrenume.getText();
            }
        });


        JLabel jLabelEmail = new JLabel();
        setTextandSize(jLabelEmail,"E-mail:",60,jPanel);

        JTextField jEmail = new JTextField("marius.ionescu@yahoo.com",17);
        jEmail.setPreferredSize(new Dimension(110,27));
        jPanel.add(jEmail);

        setTextandSize(jLabel2,"Data nasterii:",80, jPanel);

        SpinnerNumberModel value = new SpinnerNumberModel(1,1,31,1);
        jSpinnerZi = new JSpinner(value);
        jSpinnerZi.setPreferredSize(new Dimension(50,26));
        jPanel.add(jSpinnerZi);

        String[] months={"Ianuarie","Februarie","Martie","Aprilie","Mai","Iunie","Iulie","August","Septembrie","Octombrie","Noiembrie","Decembrie"};
        makeComboBox(jPanel,months);

        SpinnerNumberModel valueYear = new SpinnerNumberModel(1997,1950,2003,1);
        jSpinnerYear = new JSpinner(valueYear);
        jSpinnerYear.setPreferredSize(new Dimension(50,26));
        jPanel.add(jSpinnerYear);

        makeLocation(jPanel);

        ConsumerInfoForm consumerInfoForm = new ConsumerInfoForm();
        JSplitPane jSplitPane = consumerInfoForm.mySplitPane;
        jSplitPane.setLeftComponent(jPanel);
        jSplitPane.setRightComponent(jPanel1);
        jFrame.add(jSplitPane);
    }
    public void initalizeFrameWithMenu(EventService eventService){
        jFrame = new JFrame("Detalii client");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setMinimumSize(new Dimension(650,600));
        jFrame.setMaximumSize(new Dimension(650,600));

        //initializePanels(onlineTicketsForm,eventService);
        JMenuBar jMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Alege");
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
        putTextFields();
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
