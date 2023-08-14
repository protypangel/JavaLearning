package org.example.ia.neural.network.neuron;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class Neuron {
    List<Synapse> before = new ArrayList<>();
    List<Synapse> after = new ArrayList<>();
    public Double aggregation() {
        return 0.0;
    }
    void refreshAggregation () {}
}