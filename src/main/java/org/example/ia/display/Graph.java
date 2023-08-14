package org.example.ia.display;

import org.example.ia.display.draw.Arrow;
import org.example.ia.display.draw.Circle;
import org.example.ia.display.draw.Draw;
import org.example.ia.neural.network.NeuralNetwork;
import org.example.ia.neural.network.NeuralNetworkBuilder;
import org.example.ia.neural.network.neuron.Input;
import org.example.ia.neural.network.neuron.Neuron;
import org.example.ia.neural.network.neuron.Output;
import org.example.ia.neural.network.neuron.Synapse;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Graph  extends JPanel {
    private Map<Integer, Draw> circles, arrows;
    private int maxHeight;
    public static int d = 50, r = d /2;
    public static Point padding = new Point(100, 30);
    BiConsumer<Integer, Double> aggregationCalculate = (key, aggregation) ->
        this.circles.get(key).setOutline(aggregation.equals(0.0) ? Color.black : Color.green, aggregation);
    public Graph (NeuralNetworkBuilder builder) {
        this.circles = new HashMap<>();
        this.arrows = new HashMap<>();


        this.maxHeight = builder.getMaxHeight();
        NeuralNetwork neural = builder.build(aggregationCalculate);

        for (int index = 0, size = neural.getInputs().size(); index < size; index++) {
            neuron(
                0,
                index,
                neural.getInputs().get(index),
                size,
                (arrow) -> {}
            );
        }
        neural.getOutputs().forEach(Neuron::aggregation);
//        new Thread(() -> {
//            while (true) {
//                this.updateUI();
//                try {
//                    Thread.sleep(1000 / 120);
//                } catch (InterruptedException e) {
//                }
//            }
//        }).start();
    }
    private void neuron(int depth, int index, Neuron neuron, int size, Consumer<Circle> consumer) {
        var hashcode = neuron.hashCode();
        if (circles.containsKey(hashcode)) {
            consumer.accept((Circle) circles.get(hashcode));
        } else {
            Color color = switch (neuron) {
                case Input i: yield Color.yellow;
                case Output o: yield Color.red;
                default: yield Color.black;
            };
            var circle = new Circle(
                (d + padding.x) * depth,
                (d + padding.y) * index - (size - this.maxHeight) * (d + padding.y) / 2 + 10,
                color
            );
            consumer.accept(circle);
            circles.put(hashcode, circle);
            synapses(depth, neuron.getAfter(), circle);
        }
    }

    private void synapses(int depth, List<Synapse> synapses, Circle start) {
        for (int index = 0, size = synapses.size(); index < size; index++) {
            var synapse = synapses.get(index);
            var hashcode = synapse.hashCode();
            if (arrows.containsKey(hashcode)) {

            } else {
                var arrow = new Arrow(start, depth, index, synapse::getWeight);
                arrows.put(hashcode, arrow);
                neuron(depth+1, index, synapse.getAfter(), size, arrow::setFinish);
            }
        }
    }

    public void paint(Graphics g) {
        var g2D = (Graphics2D)g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        arrows.forEach((key, value) -> value.draw(g));
        circles.forEach((key, value) -> value.draw(g));
    }
}
