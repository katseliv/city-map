package com.company;

import com.company.objects.*;
import com.company.objects.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.text.AttributedString;

public class DrawPanel extends JPanel {
    private static final int SCALE = 100;
    private static final int INDENT = 10;

    private final Flower flower = new Flower(new Color(240, 20, 20));
    private final Road verticalRoad = new Road(Color.GRAY, true);
    private final Road horizontalRoad = new Road(Color.GRAY, false);
    private final Car verticalCar = new Car(new Color(0x6C6CD2), true);
    private final Car horizontalCar = new Car(new Color(0x6C6CD2), false);

    private final Sun sun = new Sun(60, 700, 15, Color.ORANGE);

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        drawBackground(g2d);
        drawRoad(g2d);
        drawHouses(g2d);
        drawCar(g2d);
        drawTable(g2d);
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
        verticalRoad.draw(g2d,  new Point(SCALE + INDENT, 0), 8);
        horizontalRoad.draw(g2d, new Point(SCALE * 2 + INDENT, SCALE * 2), 6);
        verticalRoad.drawCrossWalk(g2d, false, new Point(SCALE * 5 + INDENT, SCALE * 2));
        verticalRoad.rotation(g2d, new Point(SCALE * 7 + INDENT, SCALE * 2), 0, 90);
        verticalRoad.draw(g2d, new Point(SCALE * 8 + INDENT, SCALE * 3), 1);
        verticalRoad.rotation(g2d, new Point(SCALE * 7 + INDENT, SCALE * 3), 270, 90);
        horizontalRoad.draw(g2d, new Point(SCALE * 6 + INDENT, SCALE * 4), 2);
        verticalRoad.rotation(g2d, new Point(SCALE * 5 + INDENT, SCALE * 4), 90, 90);
        verticalRoad.draw(g2d, new Point(SCALE * 5 + INDENT, SCALE * 5), 2);
        verticalRoad.rotation(g2d, new Point(SCALE * 5 + INDENT, SCALE * 6), 180, 90);
        horizontalRoad.draw(g2d, new Point(SCALE * 6 + INDENT, SCALE * 7), 14);
        verticalRoad.drawCrossWalk(g2d, false, new Point(SCALE * 10 + INDENT, SCALE * 7));
        verticalRoad.rotation(g2d, new Point(INDENT, SCALE * 7), 270, 90);
        horizontalRoad.draw(g2d, new Point(-SCALE + INDENT, SCALE * 8), 2);

        horizontalRoad.draw(g2d, new Point(SCALE * 14 + INDENT, SCALE * 2), 1);
        verticalRoad.rotation(g2d, new Point(SCALE * 14 + INDENT, SCALE * 2), 0, 90);
        verticalRoad.draw(g2d, new Point(SCALE * 15 + INDENT, SCALE * 3), 1);
        verticalRoad.rotation(g2d, new Point(SCALE * 14 + INDENT, SCALE * 3), 270, 90);
        horizontalRoad.draw(g2d, new Point(SCALE * 14 + INDENT, SCALE * 4), 1);
        verticalRoad.rotation(g2d, new Point(SCALE * 13 + INDENT, SCALE * 3), 180, 90);
        verticalRoad.draw(g2d, new Point(SCALE * 13 + INDENT, SCALE * 3), 1);
        verticalRoad.rotation(g2d, new Point(SCALE * 13 + INDENT, SCALE * 2), 90, 90);

        verticalRoad.draw(g2d, new Point(SCALE * 14 + INDENT, SCALE * 5), 2);
        verticalRoad.draw(g2d, new Point(SCALE * 14 + INDENT, 0), 2);

        verticalRoad.draw(g2d, new Point(SCALE * 7 + INDENT, SCALE * 8), 3);

        horizontalRoad.draw(g2d, new Point(SCALE * 16 + INDENT, SCALE * 3), 4);
    }

    public void drawHouses(Graphics2D g2d) {
        House house = new House(new Color(142, 39, 13), true,SCALE * 4, SCALE * 2);
        house.draw(g2d, new Point(SCALE * 10 + INDENT, SCALE * 2));
        House house1 = new House(new Color(41, 145, 194), true, SCALE * 5, SCALE * 2);
        house1.draw(g2d, new Point(SCALE * 3 + INDENT - 50, SCALE * 4));
        House house2 = new House(new Color(157, 92, 222), false,SCALE * 5, SCALE * 2);
        house2.draw(g2d, new Point(SCALE * 3 + INDENT, -SCALE));
        House house3 = new House(new Color(142, 39, 13), true,SCALE * 6, SCALE * 2);
        house3.draw(g2d, new Point(-SCALE - 50 + INDENT, SCALE));
        House house4 = new House(new Color(41, 145, 194), false, SCALE * 3, SCALE * 2);
        house4.draw(g2d, new Point(SCALE * 9 + INDENT, -SCALE));
        House house5 = new House(new Color(240, 255, 14), false, SCALE * 9, SCALE * 2);
        house5.draw(g2d, new Point(SCALE * 9 + INDENT, SCALE * 9));
    }

    public void drawCar(Graphics2D g2d) {
        verticalCar.draw(g2d, new Point(SCALE + INDENT * 3, SCALE * 4));
        verticalCar.draw(g2d, new Point(SCALE * 13 + INDENT * 3, SCALE * 3));
        verticalCar.setColor(new Color(215, 255, 0));
        verticalCar.draw(g2d, new Point(SCALE * 5 + INDENT * 3, SCALE * 6));
        horizontalCar.setColor(new Color(201, 0, 255));
        horizontalCar.draw(g2d, new Point(SCALE * 12 + INDENT, SCALE * 7 + INDENT * 2));
    }

    public void drawTable(Graphics2D g2d) {
        g2d.setColor(new Color(217, 157, 15));
        g2d.fillRect(SCALE * 16 + INDENT, SCALE * 5, SCALE * 2, SCALE);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(6.0f));
        g2d.drawLine(SCALE * 17 + INDENT, SCALE * 6 + 4, SCALE * 17 + INDENT, SCALE * 7 - 7);

        AffineTransform fontAT = new AffineTransform();
        Font font = new Font("serif", Font.BOLD, 19).deriveFont(fontAT);
        AttributedString as = new AttributedString("Welcome to My City !!!");
        as.addAttribute(TextAttribute.FONT, font);

        g2d.drawString(as.getIterator(), SCALE * 16 + INDENT + 5, SCALE * 6 - 50);
    }
}
