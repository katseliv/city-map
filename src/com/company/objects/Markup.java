package com.company.objects;

import java.awt.*;

public class Markup {
    private static final Color COLOR = new Color(255, 255, 255);
    private int length;
    private int width;

    public Markup(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Color getColor() {
        return COLOR;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
