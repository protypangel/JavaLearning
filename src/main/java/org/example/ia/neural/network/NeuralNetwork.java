package org.example.ia.neural.network;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.ia.neural.network.neuron.Neuron;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

@Getter
@AllArgsConstructor
public class NeuralNetwork {
    public static Double sigmoid (Neuron neuron) {
        double sum = neuron.getBefore().stream().reduce(0.0, (accumulator, current) -> current.getWeight() + accumulator, Double::sum);
        return 1 / (1 + Math.exp(-sum));
    }
    protected List<Neuron> inputs;
    protected List<Neuron> outputs;
}
