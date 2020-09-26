package com.company;

import com.company.objects.Point;
import java.awt.*;

public interface Drawable {
    void draw(Graphics2D g2d, Point point);
}
