package org.example.Java.Java11;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Java11 {
    public static void main(String[] args) {
        Stream<String> java11String = "A\nB".lines();
        Stream.of(1,2,3,4,5)
            .filter(Predicate.not(e -> e > 10));
    }
}
