package ru.geekbrains.java_one.homework.homework_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static int WIN_WIDTH;
    private static int WIN_HEIGHT;
    private static int WIN_POSX;
    private static int WIN_POSY;
    private static int MAP_HORIZONTAL_MARGIN;

    private Map map;
    private SettingsWindow settings;

    GameWindow() {

        GraphicsDevice screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        WIN_WIDTH = (int) screenSize.getDisplayMode().getWidth()/2;
        WIN_HEIGHT = (int) screenSize.getDisplayMode().getHeight()/2;
        WIN_POSX = WIN_WIDTH/2;
        WIN_POSY =WIN_HEIGHT/2;
        MAP_HORIZONTAL_MARGIN = (WIN_WIDTH - WIN_HEIGHT)/2;

        setLocation(WIN_POSX, WIN_POSY);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        map = new Map();
        settings = new SettingsWindow(this);

        JButton buttonStart = new JButton("New game");
        JButton buttonExit = new JButton("Exit");

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelBottomButtons = new JPanel();
        panelBottomButtons.setLayout(new GridLayout(1, 2));
        panelBottomButtons.add(buttonStart);
        panelBottomButtons.add(buttonExit);
        add(panelBottomButtons, BorderLayout.SOUTH);

        add(map);

        setVisible(true);
    }

    void startNewGame(int mode, int fieldSize, int winLength) {
        map.startNewGame(mode, fieldSize, winLength, MAP_HORIZONTAL_MARGIN);
    }

}
