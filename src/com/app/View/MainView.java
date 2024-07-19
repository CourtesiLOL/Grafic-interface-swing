package com.app.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView extends JFrame {

    private JPanel mainPanel;
    private JPanel appBarJPanel;
    private JPanel itemListPanel;
    private JPanel menuBar;

    private JButton exitBtn;
    private JButton maximiceBtn;

    public MainView() {
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(true);

        initComponents();
        

        setLocationRelativeTo(null);

    }

    private void initComponents() {

        mainPanel = new JPanel();
        appBarJPanel = new JPanel();
        itemListPanel = new JPanel();
        menuBar = new JPanel();

        exitBtn = new JButton();
        maximiceBtn = new JButton();

        configureInterface();
        pack();
    }

    private void configureInterface(){

        //MainPanelConfigureView
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(600,375));

        mainPanel.add(appBarJPanel, BorderLayout.NORTH);
        mainPanel.add(itemListPanel,BorderLayout.CENTER);
        mainPanel.add(menuBar, BorderLayout.WEST);

        //AppBarConfigureView
        appBarJPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        appBarJPanel.setBackground(new Color(102, 102, 102));
        appBarJPanel.setPreferredSize(new Dimension(WIDTH, 40));
        appBarJPanel.add(maximiceBtn);
        appBarJPanel.add(exitBtn);

        
        //ExistButtonConfigureView
        exitBtn.setText("X");
        exitBtn.setForeground(Color.black);
        exitBtn.setPreferredSize(new Dimension(50,25));

        //MaximiceButtonConfigureView
        maximiceBtn.setText("[]");
        maximiceBtn.setForeground(Color.black);
        maximiceBtn.setPreferredSize(new Dimension(50,25));
        

        //itemListPanelConfigureView
        itemListPanel.setBackground(Color.CYAN);

        //menuBarConfigureView
        menuBar.setBackground(Color.GREEN);
        menuBar.setPreferredSize(new Dimension(50,HEIGHT));


        getContentPane().add(mainPanel);


    }


    public JPanel getAppBar(){
        return appBarJPanel;
    }

    public JButton getExisButton(){
        return exitBtn;
    }
}
