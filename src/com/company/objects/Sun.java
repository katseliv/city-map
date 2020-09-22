package com.company.objects;

import com.company.Drawable;

import java.awt.*;

public class Sun implements Drawable { // должен быть либо абстрактным, либо реализовывать метод
    private int x, y, r, R, n;
    private Color color;

    public Sun(int x, int y, int r, int r1, int n, Color color) {
        this.x = x;
        this.y = y;
        this.r = r;
        R = r1;
        this.n = n;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        drawSun(g2d, x, y, r, R, n, color);
    }

    private void drawSun(Graphics2D g2d, int x, int y, int radiusOfSunBody, int radiusOfBeam, int numberOfBeam, Color color) {

        drawSunBody(g2d, x, y, radiusOfSunBody, color);

        double angel = 2 * Math.PI / numberOfBeam;

        for (int i = 0; i < numberOfBeam; i++) {

            double dx1 = radiusOfSunBody * Math.cos(angel * i) + x;
            double dy1 = radiusOfSunBody * Math.sin(angel * i) + y;
            double dx2 = radiusOfBeam * Math.cos(angel * i) + x;
            double dy2 = radiusOfBeam * Math.sin(angel * i) + y;

            g2d.setStroke(new BasicStroke(10.0f));
            g2d.drawLine((int) dx1, (int) dy1, (int) dx2, (int) dy2);
        }

    }

    private void drawSunBody(Graphics2D g2d, int x, int y, int radiusOfSunBody, Color color) {
        g2d.setColor(color);
        g2d.fillOval(x - radiusOfSunBody, y - radiusOfSunBody, 2 * radiusOfSunBody, 2 * radiusOfSunBody);
    }
}
