package org.example.ia.neural.network.neuron;

import lombok.Setter;

import java.util.function.*;

@Setter
public class Output extends Neuron {
    Aggregation aggregation;
    public Output (BiConsumer<Integer, Double> aggregationCalculate) {
        aggregation = new Aggregation(this::getBefore, hashCode(), aggregationCalculate, DoubleUnaryOperator.identity());
    }

    @Override public Double aggregation () {
        return aggregation.get();
    }
}
