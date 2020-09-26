package com.company.objects;

import com.company.Drawable;

import java.awt.*;

public class Road{
    private final Color color;
    private final boolean isVertical;
    private static final Border BORDER = new Border(new Color(55, 60, 55), 10);
    private static final Markup MARKUP = new Markup(40, 10);
    private static final int SCALE = 100;
    private static final int INDENT = 30;

    public Road(Color color, boolean isVertical) {
        this.color = color;
        this.isVertical = isVertical;
    }

    public void draw(Graphics2D g2d, Point point, int length){
        if (isVertical) {
            verticalRoad(g2d, point, length);
        } else {
            horizontalRoad(g2d, point, length);
        }
    }

    public void verticalRoad(Graphics2D g2d, Point point, int length) {
        for (int i = 0; i < length; i++) {
            verticalPartOfRoad(g2d, point);
            point.setY(point.getY() + SCALE);
        }
    }

    public void horizontalRoad(Graphics2D g2d, Point point, int length) {
        for (int i = 0; i < length; i++) {
            horizontalPartOfRoad(g2d, point);
            point.setX(point.getX() + SCALE);
        }
    }

    public void verticalPartOfRoad(Graphics2D g2d, Point point) {
        drawPrimaryBlock(g2d, point);

        g2d.setColor(BORDER.getColor());
        g2d.fillRect(point.getX() - BORDER.getThickness(), point.getY(), BORDER.getThickness(), SCALE);
        g2d.fillRect(point.getX() + SCALE, point.getY(), BORDER.getThickness(), SCALE);
        g2d.setColor(MARKUP.getColor());
        g2d.fillRect(point.getX() + SCALE / 2 - MARKUP.getWidth() / 2, point.getY() + INDENT, MARKUP.getWidth(), MARKUP.getLength());
    }

    public void horizontalPartOfRoad(Graphics2D g2d, Point point) {
        drawPrimaryBlock(g2d, point);

        g2d.setColor(BORDER.getColor());
        g2d.fillRect(point.getX(), point.getY() - BORDER.getThickness(), SCALE, BORDER.getThickness());
        g2d.fillRect(point.getX(), point.getY() + SCALE, SCALE, BORDER.getThickness());
        g2d.setColor(MARKUP.getColor());
        g2d.fillRect(point.getX() + INDENT, point.getY() + SCALE / 2 - MARKUP.getWidth() / 2, MARKUP.getLength(), MARKUP.getWidth());
    }

    public void drawPrimaryBlock(Graphics2D g2d, Point point) {
        g2d.setColor(color);
        g2d.fillRect(point.getX(), point.getY(), SCALE, SCALE);
    }

    public void drawCrossWalk(Graphics2D g2d, boolean isVertical, Point point) {
        if (isVertical) {
            verticalCrossWalk(g2d, point);
        } else {
            horizontalCrossWalk(g2d, point);
        }
    }

    public void verticalCrossWalk(Graphics2D g2d, Point point) {
        verticalPartOfRoad(g2d, point);

        g2d.setColor(color);
        g2d.fillRect(point.getX() - BORDER.getThickness(), point.getY() + INDENT, MARKUP.getWidth(), MARKUP.getLength());
        g2d.fillRect(point.getX() + SCALE, point.getY() + INDENT, MARKUP.getWidth(), MARKUP.getLength());

        g2d.setColor(MARKUP.getColor());
        g2d.fillRect(point.getX() + SCALE / 4 - MARKUP.getWidth() / 2, point.getY() + INDENT, MARKUP.getWidth(), MARKUP.getLength());
        g2d.fillRect(point.getX() + SCALE * 3 / 4 - MARKUP.getWidth() / 2, point.getY() + INDENT, MARKUP.getWidth(), MARKUP.getLength());
    }

    public void horizontalCrossWalk(Graphics2D g2d, Point point) {
        horizontalPartOfRoad(g2d, point);

        g2d.setColor(color);
        g2d.fillRect(point.getX() + INDENT, point.getY() - BORDER.getThickness(), MARKUP.getLength(), MARKUP.getWidth());
        g2d.fillRect(point.getX() + INDENT, point.getY() + SCALE, MARKUP.getLength(), MARKUP.getWidth());

        g2d.setColor(MARKUP.getColor());
        g2d.fillRect(point.getX() + INDENT, point.getY() + SCALE / 4 - MARKUP.getWidth() / 2, MARKUP.getLength(), MARKUP.getWidth());
        g2d.fillRect(point.getX() + INDENT, point.getY() + SCALE * 3 / 4 - MARKUP.getWidth() / 2, MARKUP.getLength(), MARKUP.getWidth());
    }

    public void rotation(Graphics2D g2d, Point point, int startAngel, int angel){
        g2d.setColor(BORDER.getColor());
        g2d.fillArc(point.getX() - BORDER.getThickness(), point.getY() - BORDER.getThickness(), SCALE * 2 + BORDER.getThickness() * 2, SCALE * 2 + BORDER.getThickness() * 2, startAngel, angel);

        g2d.setColor(color);
        g2d.fillArc(point.getX(), point.getY(), SCALE * 2, SCALE * 2, startAngel, angel);
    }
}
