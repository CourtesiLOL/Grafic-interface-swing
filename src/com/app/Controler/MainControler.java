package com.app.Controler;

import com.app.View.MainView;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainControler {

    private int mouseX, mouseY; 

    //Components
    private final MainView view;

    

    public MainControler() {

        view = new MainView();
        setEvents();

    }

    public void setVisible(boolean visible) {

        view.setVisible(visible);
    }

    private void setEvents() {

        addDragFunctionality();
        enableExistBtn();

    }

    private void addDragFunctionality() {
        JPanel appBarJPanel = view.getAppBar();
        // Añadir MouseListener y MouseMotionListener al appBarJPanel para mover la
        // ventana
        appBarJPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                System.out.println("se mueve a: x:"+mouseX+" y:"+mouseY );
            }
        });

        appBarJPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                System.out.println("se mueve a: x:"+x+" y:"+y);
                view.setLocation(x - mouseX, y - mouseY);
            }
        });
    }

    private void enableExistBtn(){
        JButton exitBtn = view.getExisButton();

        exitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                System.exit(0);
            }
        });
    }

}