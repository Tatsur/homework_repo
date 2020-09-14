package ru.geekbrains.java_one.homework.homework8a;

import javax.swing.*;
import java.awt.*;

public class Token extends JPanel {

    private final int posX;
    private final int posY;
    private final int width;
    private final int height;
    private final String TOKEN;
    private static final String FONT_NAME = "Dialog";
    private static final int FONT_TYPE = Font.BOLD;
    private static Font font;

    public Token(int posX, int posY, int width, int height, char token) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        font = new Font(FONT_NAME,FONT_TYPE,width);
        TOKEN = String.valueOf(token);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics(font);
        Rectangle rectangle = new Rectangle(posX,posY,width,height);
        int x = rectangle.x+(rectangle.width-metrics.stringWidth(TOKEN))/2;
        int y = rectangle.y+(rectangle.height-metrics.getHeight())/2+metrics.getAscent();
        g.drawString(TOKEN,x,y);

    }
}
