package org.example.Java8;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Comparator implements Comparator<Java8Comparator.Java8ComparatorA> {
    boolean invert = true;
    boolean byName = false;
    public static void main(String[] args) {
        List<Java8Comparator.Java8ComparatorA> list = Arrays.asList(
            new Java8Comparator.Java8ComparatorA(2, "RANK 2"),
            new Java8Comparator.Java8ComparatorA(1, "RANK 1")
        );

        Java8Comparator comparator = new Java8Comparator();
        Collections.sort(list, comparator);
        System.out.println(list);
    }
    public int compare (Java8Comparator.Java8ComparatorA A, Java8Comparator.Java8ComparatorA B) {
        int compare;
        if (byName) compare = A.name.compareTo(B.name);
        else compare = A.rank - B.rank;
        return compare * (invert ? -1 : 1);
    }
    @AllArgsConstructor
    public static class Java8ComparatorA {
        int rank;
        String name;
        public String toString() {
            return String.format("#%d-%s", rank, name);
        }
    }
}
