package org.example.ia.display;

import org.example.ia.neural.network.Layer;
import org.example.ia.neural.network.NeuralNetworkBuilder;

import javax.swing.*;

public class Display extends JFrame {
    private Display(String name, int x, int y, int width, int height) {
        super(name);

        setBounds(x, y, width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new Graph(
            new NeuralNetworkBuilder(
                1,
                new Layer(2, 2),
                3,
                () -> -1
            )
        );
        add(panel);
    }
    public static void main(String[] args) {
        new Display("Activity Graph", 3833, 0, 1294, 1399).setVisible(true);
    }
}