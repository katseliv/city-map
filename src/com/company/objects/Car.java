package com.company.objects;

import java.awt.*;

public class Car {
    private Color color;
    private static final Color COLOR_OF_WHEEL = new Color(0, 0, 0);
    private int length = 100;
    private int width = 60;

    public Car(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Graphics2D g2d, Point point){
        g2d.setColor(color);
        g2d.fillRoundRect(point.getX(), point.getY(), width, length, 50, 50);

        g2d.setColor(COLOR_OF_WHEEL);
        g2d.fillRoundRect(point.getX() - 15, point.getY(), 20, 25, 30, 30);

        g2d.fillRoundRect(point.getX() - 5 + width, point.getY(), 20, 25, 30, 30);

        g2d.fillRoundRect(point.getX() - 15, point.getY() + length - 25, 20, 25, 40, 40);

        g2d.fillRoundRect(point.getX() - 5 + width, point.getY() + length - 25, 20, 25, 40, 40);
    }


}
