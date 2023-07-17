package org.example.Java12;

public class Java12 {
    public static void main(String[] args) {
        String SwitchExpression = switch (args.length) {
            case 0, 1 -> "SHORT";
            case 2 -> {
                System.out.println("ITS A MEDIUM TEXT");
                // yield is the same as return for function
                yield "MEDIUM";
            }
            default -> "LONG";
        };
        String java12String = "Text".indent(10);
    }
    public static void PatternMattingForInstanceOf(Object obj) {
        if (obj instanceof String) {
            System.out.println("It's a string");
        } else if (obj instanceof Integer i) {
            System.out.println(i);
        }
    }
}
