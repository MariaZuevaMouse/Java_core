package com.company.mz.thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadTest9ui {
    static JFrame gui;

    public static void main(String[] args) {
        guiGo();
    }
    public static void someLongWork(){
        long time = System.currentTimeMillis();
        for(int i = 0; i<100_000L; i++){
            long a = i*8;
            for(long j = 0; j<a; j++){
                long b = j*4;
            }
        }
    }
    private  static  void guiGo(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        gui = new JFrame() {
        };
        JPanel jPanel = new JPanel();
        gui.add(jPanel);

        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setTitle("Multithreading");
        gui.setResizable(false);
        gui.setSize(screenSize.width / 4, screenSize.height / 4);
        gui.setLocation(screenSize.width / 2, screenSize.height / 2);

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        jPanel.add(button1);
        jPanel.add(button2);
        jPanel.add(button3);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 1 pressed!");
                someLongWork();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 2 pressed!");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 3 pressed!");
            }
        });
    }
}
