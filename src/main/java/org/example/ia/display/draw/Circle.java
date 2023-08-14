package org.example.ia.display.draw;

import lombok.Getter;
import org.example.ia.display.Graph;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.function.Consumer;

@Getter
public class Circle implements Draw {
    private int x, startX,y;
    private Color color;
    Consumer<Graphics> outlined;
    public Circle (int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.outlined = graphics -> {};
    }
    @Override public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, Graph.d, Graph.d);
        outlined.accept(g);
        x++;
    }
    @Override
    public void setOutline(Color color, Double aggregation) {
        String text = new DecimalFormat("0.00").format(aggregation);
        outlined = graphics -> {
            graphics.setColor(color);
            graphics.drawOval(x, y, Graph.d, Graph.d);
            graphics.setColor(Color.white);
            FontMetrics metrics = graphics.getFontMetrics();
            graphics.drawString(text, x + Graph.r - metrics.stringWidth(text) / 2, y + Graph.r + metrics.getHeight() / 4);
        };
    }
}
