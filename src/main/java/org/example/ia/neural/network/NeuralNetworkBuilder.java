package org.example.ia.neural.network;

import org.example.ia.neural.network.neuron.Input;
import org.example.ia.neural.network.neuron.Neuron;
import org.example.ia.neural.network.neuron.Output;
import org.example.ia.neural.network.neuron.Synapse;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.DoubleSupplier;
import java.util.stream.Stream;

public class NeuralNetworkBuilder {
     private int inputs;
     private Layer layer;
     private int outputs;
     private DoubleSupplier initWeight;
     public Integer getMaxHeight() {
         return Math.max(Math.max(inputs, outputs), layer.height());
     }

    public NeuralNetworkBuilder(int inputs, Layer layer, int outputs, DoubleSupplier initWeight) {
        this.inputs = inputs;
        this.layer = layer;
        this.outputs = outputs;
        this.initWeight = initWeight;
    }
     public NeuralNetwork build (BiConsumer<Integer, Double> aggregationCalculate) {
         List<Neuron> inputs = new ArrayList<>();
         List<Neuron> outputs = new ArrayList<>();

        // Inputs
        for (var index = 0; index < this.inputs; index++)
            inputs.add(new Input(0.0));
        // Layers
        List<Neuron> layers = inputs;
        for (int position = 0, height = this.layer.height(), length = this.layer.length(); position < length; position++)
            layers = layer(layers, height, aggregationCalculate);
        // Outputs
         for (var index = 0; index < this.outputs; index++)
             outputs.add(new Output(aggregationCalculate));

        for (var layer : layers) {
            for (var output : outputs) {
                var synapse = new Synapse(initWeight.getAsDouble(), layer, output);
                layer.getAfter().add(synapse);
                output.getBefore().add(synapse);
            }
        }

        return new NeuralNetwork(inputs, outputs);
     }
    private List<Neuron> layer (List<Neuron> previous, int height, BiConsumer<Integer, Double> aggregationCalculate) {
        List<Neuron> layers = new ArrayList<>();

        for (var index = 0; index < height; index++) {
            var after = new org.example.ia.neural.network.neuron.Layer(aggregationCalculate);
            for (var before : previous) {
                var synapse = new Synapse(initWeight.getAsDouble(), before, after);
                before.getAfter().add(synapse);
                after.getBefore().add(synapse);
            }
            layers.add(after);
        }
        return layers;
    }

}
