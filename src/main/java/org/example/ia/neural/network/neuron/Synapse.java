package org.example.ia.neural.network.neuron;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.ia.neural.network.neuron.Neuron;

import java.util.function.DoubleSupplier;

@Getter
@AllArgsConstructor
public class Synapse {
    double weight;
    Neuron before, after;
}