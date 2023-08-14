package org.example.ia.display.draw;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.function.DoubleSupplier;

import static org.example.ia.FunctionUtil.Sigmoid;
import static org.example.ia.display.Graph.d;

@Setter(value = AccessLevel.NONE)
@Getter
public class Arrow implements Draw {
    private Circle start;
    @Setter(value = AccessLevel.PUBLIC)
    private Circle finish;
    private DoubleSupplier supplier;
    int depth; int index;
    public Arrow (Circle start, int depth, int index, DoubleSupplier supplier) {
        this.start = start;
        this.supplier = supplier;
        this.depth = depth;
        this.index = index;
    }
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.orange);
        g2D.setStroke(new BasicStroke((float) (1 + 9 * Sigmoid(supplier.getAsDouble()))));
        g2D.drawLine(start.getX() + d/ 2, start.getY() + d/2, finish.getX() + d/2, finish.getY() + d/2);
    }

    @Override
    public void setOutline(Color color, Double value) {
    }
}
