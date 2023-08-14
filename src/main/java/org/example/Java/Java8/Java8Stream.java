package org.example.Java.Java8;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * parallelStream: pour une utilisation dans les thread (thread-safe)
 * flatMap: transforme un Stream<List<E>> en Stream<E>
 * peek: fait la meme chose qu'un forEach sauf que l'on peut continuer le stream
  */
public class Java8Stream {
    @AllArgsConstructor
    @Getter
    public static class Human implements Comparable<Human> {
        private String name;
        private int age;
        private List<String> favoriteFood;
        public String toString() {
            return String.format("#%d-%s", age, name);
        }

        @Override
        public int compareTo(Human o) {
            return age - o.age;
        }
    }
    public static void main (String []args) {
        List<Human> humans = Arrays.asList(
            new Human("Durand", 30, List.of("Water", "Coca cola", "Fanta")),
            new Human("Durand", 20, List.of("Water")),
            new Human("valent", 10, List.of("Water", "Coca cola", "Orangina"))
        );
        if (humans.stream().anyMatch(human -> human.age > 18)) System.out.println("There is an adult");
        System.out.println(
            humans.stream()
                .filter(human -> human.age > 18)
                .map(Human::getName)
                .collect(Collectors.toList())
        );
        System.out.println(
            humans.stream()
                .filter(human -> human.age > 18)
                .flatMap(human -> human.getFavoriteFood().stream())
                .collect(Collectors.toList())
        );
        System.out.println(
            humans.stream().sorted().toList()
        );
        System.out.println(
            humans.stream().collect(Collectors.toMap(
                Human::getName,
                Function.identity(),
                (existing, replacement) -> existing
            ))
        );
        System.out.println(
            humans.stream()
                .collect(Collectors.groupingBy(
                    human -> human.age > 18 ? "Majeur" : "Mineur",
                    Collectors.mapping(Human::getFavoriteFood, Collectors.toList())
                ))
        );
    }
}
