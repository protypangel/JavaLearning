package org.example.ia.display.draw;

import java.awt.*;

public interface Draw {
    void draw (Graphics g);

    void setOutline(Color color, Double aggregation);
}
