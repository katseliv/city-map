package com.company.objects;

import com.company.Drawable;
import java.awt.*;

public class Car implements Drawable {
    private Color color;
    private boolean isVertical;
    private static final Color COLOR_OF_WHEEL = new Color(0, 0, 0);
    private int length = 100;
    private int width = 60;

    public Car(Color color, boolean isVertical) {
        this.color = color;
        this.isVertical = isVertical;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d, Point point) {
        g2d.setColor(color);
        if (isVertical) {
            verticalCar(g2d, point);
        } else {
            horizontalCar(g2d, point);
        }
    }

    private void verticalCar(Graphics2D g2d, Point point){
        g2d.fillRoundRect(point.getX(), point.getY(), width, length, 50, 50);

        g2d.setColor(COLOR_OF_WHEEL);
        g2d.fillRoundRect(point.getX() - 15, point.getY(), 20, 25, 30, 30);

        g2d.fillRoundRect(point.getX() - 5 + width, point.getY(), 20, 25, 30, 30);

        g2d.fillRoundRect(point.getX() - 15, point.getY() + length - 25, 20, 25, 40, 40);

        g2d.fillRoundRect(point.getX() - 5 + width, point.getY() + length - 25, 20, 25, 40, 40);
    }

    private void horizontalCar(Graphics2D g2d, Point point){
        g2d.fillRoundRect(point.getX(), point.getY(), length, width, 50, 50);

        g2d.setColor(COLOR_OF_WHEEL);
        g2d.fillRoundRect(point.getX(), point.getY() - 15, 25, 20, 30, 30);

        g2d.fillRoundRect(point.getX(), point.getY() - 5 + width, 25, 20, 30, 30);

        g2d.fillRoundRect(point.getX() + length - 25, point.getY() - 15, 25, 20, 40, 40);

        g2d.fillRoundRect(point.getX() + length - 25, point.getY() - 5 + width, 25, 20, 40, 40);
    }
}
