package org.example.ia;

public class FunctionUtil {
    public static Double Sigmoid(Double x) {
        return 1 / (1 + Math.exp(-x));
    }
}
