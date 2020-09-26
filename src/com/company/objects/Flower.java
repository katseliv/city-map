package com.company.objects;

import com.company.Drawable;

import java.awt.*;

public class Flower implements Drawable {
    private Color color;
    private static final Color CENTER = new Color(255, 235, 50);
    private static final int RADIUS = 10;

    public Flower(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d, Point center) {
        g2d.setColor(color);
        g2d.fillArc(center.getX() - 2 * RADIUS, center.getY() - 2 * RADIUS, 4 * RADIUS, 4 * RADIUS, 10, 70);
        g2d.fillArc(center.getX() - 2 * RADIUS, center.getY() - 2 * RADIUS, 4 * RADIUS, 4 * RADIUS, 100, 70);
        g2d.fillArc(center.getX() - 2 * RADIUS, center.getY() - 2 * RADIUS, 4 * RADIUS, 4 * RADIUS, 190, 70);
        g2d.fillArc(center.getX() - 2 * RADIUS, center.getY() - 2 * RADIUS, 4 * RADIUS, 4 * RADIUS, 280, 70);

        g2d.setColor(CENTER);
        g2d.fillOval(center.getX() - RADIUS, center.getY() - RADIUS, 2 * RADIUS, 2 * RADIUS);
    }
}
