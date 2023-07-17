package org.example.Java12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java12Teeing {
    public static void main(String[] args) {
        Collector<Double, ?, Double> calculatingMean = Collectors.teeing(
            Collectors.summingDouble(i -> i),
            Collectors.counting(),
            (sum, count) -> sum / count
        );
        Collector<Double, ?, Double> calculatingVarianceWithoutDividing = Collectors.teeing(
            calculatingMean,
            Collectors.toList(),
            (mean, list) -> list.stream().reduce(
                0.0,
                (accumulator, current) -> accumulator + Math.pow(current - mean, 2)
            )
        );
        Double variance = Stream.of(25.0, 26.0, 27.0, 30.0, 32.0)
            .collect(
                Collectors.teeing(
                    calculatingVarianceWithoutDividing,
                    Collectors.counting(),
                    (varianceWithoutDiving, count) -> varianceWithoutDiving / count
                )
            );
        System.out.println(variance);
    }
}
