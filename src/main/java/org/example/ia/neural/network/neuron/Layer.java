package org.example.ia.neural.network.neuron;

import org.example.ia.FunctionUtil;

import java.util.function.BiConsumer;

public class Layer extends Neuron {
    Aggregation aggregation;
    public Layer (BiConsumer<Integer, Double> aggregationCalculate) {
        aggregation = new Aggregation(this::getBefore, hashCode(), aggregationCalculate, FunctionUtil::Sigmoid);
    }

    @Override public Double aggregation () {
        return aggregation.get();
    }
    @Override public void refreshAggregation () {
        this.aggregation.refresh();
    }
}
