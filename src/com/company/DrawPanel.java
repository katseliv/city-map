package com.company;

import com.company.objects.*;
import com.company.objects.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class DrawPanel extends JPanel {
    private static final int SCALE = 100;
    private static final int INDENT = 10;

    private final Flower flower = new Flower(new Color(240, 20, 20));
    private final Road road = new Road(Color.GRAY);
    private final Car car = new Car(new Color(0x6C6CD2));

    private final Sun sun = new Sun(700, 600, 60, 700, 15, Color.ORANGE);

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        drawBackground(g2d);
        drawRoad(g2d);
        drawHouses(g2d);
        drawCar(g2d);

//        sun.draw(g2d);
    }

    public void drawBackground(Graphics2D g2d) {
        g2d.setColor(new Color(75, 135, 35));
        g2d.fillRect(0, 0, getWidth(), getHeight());
        drawNet(g2d);
        drawFlowers(g2d);
    }

    private void drawNet(Graphics2D g2d) {
        g2d.setColor(new Color(0, 0, 0));
        for (int i = 0; i <= getWidth() / SCALE; i++) {
            g2d.drawLine(SCALE * i + INDENT, 0, SCALE * i + INDENT, getHeight());
        }
        for (int i = 0; i <= getHeight() / SCALE; i++) {
            g2d.drawLine(0, SCALE * i, getWidth(), SCALE * i);
        }
    }

    private void drawFlowers(Graphics2D g2d) {
        for (int i = 0; i < 200; i++) {
            double x = Math.random() * 1900;
            double y = Math.random() * 1000;
            flower.draw(g2d, new Point((int) x, (int) y));
        }
    }

    public void drawRoad(Graphics2D g2d) {
        road.draw(g2d, true, new Point(SCALE + INDENT, 0), 8);
        road.draw(g2d, false, new Point(SCALE * 2 + INDENT, SCALE * 2), 6);
        road.drawCrossWalk(g2d, false, new Point(SCALE * 5 + INDENT, SCALE * 2));
        road.rotation(g2d, new Point(SCALE * 7 + INDENT, SCALE * 2), 0, 90);
        road.draw(g2d, true, new Point(SCALE * 8 + INDENT, SCALE * 3), 1);
        road.rotation(g2d, new Point(SCALE * 7 + INDENT, SCALE * 3), 270, 90);
        road.draw(g2d, false, new Point(SCALE * 6 + INDENT, SCALE * 4), 2);
        road.rotation(g2d, new Point(SCALE * 5 + INDENT, SCALE * 4), 90, 90);
        road.draw(g2d, true, new Point(SCALE * 5 + INDENT, SCALE * 5), 2);
        road.rotation(g2d, new Point(SCALE * 5 + INDENT, SCALE * 6), 180, 90);
        road.draw(g2d, false, new Point(SCALE * 6 + INDENT, SCALE * 7), 14);
        road.drawCrossWalk(g2d, false, new Point(SCALE * 10 + INDENT, SCALE * 7));
        road.rotation(g2d, new Point(INDENT, SCALE * 7), 270, 90);
        road.draw(g2d, false, new Point(-SCALE + INDENT, SCALE * 8), 2);

        road.draw(g2d, false, new Point(SCALE * 14 + INDENT, SCALE * 2), 1);
        road.rotation(g2d, new Point(SCALE * 14 + INDENT, SCALE * 2), 0, 90);
        road.draw(g2d, true, new Point(SCALE * 15 + INDENT, SCALE * 3), 1);
        road.rotation(g2d, new Point(SCALE * 14 + INDENT, SCALE * 3), 270, 90);
        road.draw(g2d, false, new Point(SCALE * 14 + INDENT, SCALE * 4), 1);
        road.rotation(g2d, new Point(SCALE * 13 + INDENT, SCALE * 3), 180, 90);
        road.draw(g2d, true, new Point(SCALE * 13 + INDENT, SCALE * 3), 1);
        road.rotation(g2d, new Point(SCALE * 13 + INDENT, SCALE * 2), 90, 90);

        road.draw(g2d, true, new Point(SCALE * 14 + INDENT, SCALE * 5), 2);
        road.draw(g2d, true, new Point(SCALE * 14 + INDENT, 0), 2);

        road.draw(g2d, true, new Point(SCALE * 7 + INDENT, SCALE * 8), 3);

        road.draw(g2d, false, new Point(SCALE * 16 + INDENT, SCALE * 3), 4);
    }

    public void drawHouses(Graphics2D g2d) {
        House house = new House(new Color(142, 39, 13), SCALE * 4, SCALE * 2);
        house.draw(g2d, true, new Point(SCALE * 10 + INDENT, SCALE * 2));
        House house1 = new House(new Color(41, 145, 194), SCALE * 5, SCALE * 2);
        house1.draw(g2d, true, new Point(SCALE * 3 + INDENT - 50, SCALE * 4));
        House house2 = new House(new Color(157, 92, 222), SCALE * 5, SCALE * 2);
        house2.draw(g2d, false, new Point(SCALE * 3 + INDENT, -SCALE));
        House house3 = new House(new Color(142, 39, 13), SCALE * 6, SCALE * 2);
        house3.draw(g2d, true, new Point(-SCALE - 50 + INDENT, SCALE));
        House house4 = new House(new Color(41, 145, 194), SCALE * 3, SCALE * 2);
        house4.draw(g2d, false, new Point(SCALE * 9 + INDENT, -SCALE));
        House house5 = new House(new Color(240, 255, 14), SCALE * 9, SCALE * 2);
        house5.draw(g2d, false, new Point(SCALE * 9 + INDENT, SCALE * 9));
    }

    public void drawCar(Graphics2D g2d) {
        car.draw(g2d, true, new Point(SCALE + INDENT * 3, SCALE * 4));
        car.draw(g2d, true, new Point(SCALE * 13 + INDENT * 3, SCALE * 3));
        car.setColor(new Color(215, 255, 0));
        car.draw(g2d,true, new Point(SCALE * 5 + INDENT * 3, SCALE * 6));
        car.setColor(new Color(201, 0, 255));

        car.draw(g2d, false, new Point(SCALE * 12 + INDENT, SCALE * 7 + INDENT * 2));
    }


}
