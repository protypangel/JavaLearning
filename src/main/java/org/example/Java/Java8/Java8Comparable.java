package org.example.Java.Java8;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@AllArgsConstructor
public class Java8Comparable implements Comparable<Java8Comparable> {
    private int rank;
    private String username;
    public int compareTo(Java8Comparable player) {
        return this.rank - player.rank;
    }
    public String toString() {
        return String.format("#%d-%s", rank, username);
    }
    public static void main(String[] args) {
        List<Java8Comparable> players = Arrays.asList(
            new Java8Comparable(2, "RANK 2"),
            new Java8Comparable(1, "RANK 1")
        );
        System.out.println(Java8Comparable.compare(players));
    }
    public static List<Java8Comparable> compare (List<Java8Comparable> players) {
        Collections.sort(players);
        return players;
    }
}

