package org.example.ia.neural.network.neuron;

import lombok.Setter;

@Setter
public class Input extends Neuron {
    double value;
    public Input (double value) {
        this.value = value;
    }
    public Double aggregation () {
        return this.value;
    }
}
