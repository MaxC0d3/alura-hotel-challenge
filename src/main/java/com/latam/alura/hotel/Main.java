package com.latam.alura.hotel;
import com.latam.alura.hotel.view.Login;
import com.latam.alura.hotel.view.MenuPrincipal;


import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}