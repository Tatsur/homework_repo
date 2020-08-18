package ru.geekbrains.java_one.homework.homework_7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel{
    public static final int MODE_VS_HUMAN = 0;
    public static final int MODE_VS_AI = 1;

    Map() {
        setBackground(Color.lightGray);
    }

    void startNewGame(int gameMode, int fieldSize, int winLength, int margin) {
        System.out.printf("mode: %d, size: %d, len: %d\n", gameMode, fieldSize, winLength);
        addGameFieldGrid(fieldSize,fieldSize,margin);
    }
    private void addGameFieldGrid(int fieldSizeX, int fieldsizeY, int margin){
        setLayout(new GridLayout(fieldSizeX,fieldsizeY));
        setBorder(BorderFactory.createEmptyBorder(0,margin,0,margin));

        for (int i = 0; i < (fieldSizeX*fieldsizeY) ; i++) {
            final JLabel label = new JLabel("content",SwingConstants.CENTER);
            label.setHorizontalTextPosition(0);
            label.setBorder(BorderFactory.createLineBorder(Color.black));
            add(label);
        }
    }
}
