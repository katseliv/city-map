package com.company.objects;

import java.awt.*;

public class Border {
    private Color color;
    private int thickness;

    public Border(Color color, int thickness) {
        this.color = color;
        this.thickness = thickness;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }
}
