package org.example.ia.neural.network.neuron;

import java.util.List;
import java.util.function.*;

/**
 Pour diminuer les calcules, il y a troix Supplier
 * aggregationInit : Le supplier qui est appellé lors de la recherche de la valeur de l'aggregation
 * aggregationAfter : Retournant la valeur calculer afin de ne plus la calculer
 * aggregation : Qui permet d'être appeller par la fonction aggregation et qui sert de transition entre rechercher la valeur et ne plus la rechercher.

 * Et enfin aggregationValue qui stocker la valeur calculer
 */
public class Aggregation {
    // Calcul d'aggregation
    DoubleUnaryOperator aggregationFunction;
    DoubleSupplier aggregation;
    DoubleSupplier aggregationInit = () -> {
        double sum = this.synapse.get().stream().reduce(0.0, this::reducing, Double::sum);
        this.aggregationValue = aggregationFunction.applyAsDouble(sum);
        this.aggregationCalculate.accept(this.hashCodeParent, this.aggregationValue);
        this.aggregation = this.aggregationAfter;
        return this.aggregationValue;
    };
    DoubleSupplier aggregationAfter = () -> this.aggregationValue;
    Double aggregationValue;
    Supplier<List<Synapse>> synapse;
    // Informe quand le calcul a été fait
    BiConsumer<Integer, Double> aggregationCalculate;
    int hashCodeParent;

    public Aggregation (Supplier<List<Synapse>> synapse, int hashCode, BiConsumer<Integer, Double> aggregationCalculate, DoubleUnaryOperator aggregationFunction) {
        this.synapse = synapse;
        this.hashCodeParent = hashCode;
        this.aggregationCalculate = aggregationCalculate;
        this.aggregation = aggregationInit;
        this.aggregationFunction = aggregationFunction;
    }
    public Double reducing(Double accumulator, Synapse current) {
        return current.getWeight() * current.getBefore().aggregation() + accumulator;
    }
    public Double get () {
        return aggregation.getAsDouble();
    }
    public void refresh () {
        aggregation = aggregationInit;
    }
}
