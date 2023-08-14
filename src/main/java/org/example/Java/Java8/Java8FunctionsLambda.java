package org.example.Java.Java8;

import java.util.function.*;

public class Java8FunctionsLambda {
    /** Les operator sont des fonctions qui prend en parametre un type et qui retourne le meme type
     *          Binary => Deux parametre
     *          Unary => Un parametre
     */
    BinaryOperator<Integer> binaryOperator = (integerA, integerB) -> integerA + integerB;
    UnaryOperator<Integer> unaryOperator = (integer) -> integer + 1;
    IntUnaryOperator intUnaryOperator = (integer) -> integer + 1;
    IntBinaryOperator intBinaryOperator = (integerA, integerB) -> integerA + integerB;
    DoubleUnaryOperator doubleUnaryOperator = (doubled) -> doubled + 1.0;
    DoubleBinaryOperator doubleBinaryOperator = (doubledA, doubledB) -> doubledA + doubledB;
    LongUnaryOperator longUnaryOperator = (lonG) -> lonG + 1L;
    LongBinaryOperator longBinaryOperator = (longA, longB) -> longA + longB;

    /** Les consumers ne retourne pas de type, ils servent a consummer une valeur
     */
    Consumer<Integer> consumer = integer -> {};
    BiConsumer<Integer, String> biConsumer = (integer, string) -> {};
    DoubleConsumer doubleConsumer = (doubled) -> {};
    IntConsumer intConsumer = (integer) -> {};
    LongConsumer longConsumer = (lonG) -> {};
    ObjDoubleConsumer<String> objDoubleConsumer = (string, doubled) -> {};
    ObjIntConsumer<String> objIntConsumer = (string, integer) -> {};
    ObjLongConsumer<String> objLongConsumer = (string, lonG) -> {};

    /** Les function retourne un type
     */
    Function<String, Integer> function = String::length;
    BiFunction<String, Integer, Boolean> biFunction = (string, integer) -> string.length() - integer > 0;
    DoubleFunction<Integer> doubleFunction = (doubled) -> (int) doubled;
    IntFunction<String> intFunction = (integer) -> String.format("%d", integer);
    LongFunction<String> longFunction = (lonG) -> String.format("%d", lonG);

    DoubleToIntFunction doubleToIntFunction = (doubled) -> (int) doubled;
    DoubleToLongFunction doubleToLongFunction = (doubled) -> (long) doubled;
    IntToDoubleFunction intToDoubleFunction = (integer) -> (double) integer;
    IntToLongFunction intToLongFunction = (integer) -> (long) integer;
    LongToDoubleFunction longToDoubleFunction = (lonG) -> (double) lonG;
    LongToIntFunction longToLongFunction = (lonG) -> (int) lonG;

    ToDoubleBiFunction<String, Integer> toDoubleBiFunction = (string, integer) -> (double) (string.length() + integer);
    ToDoubleFunction<Integer> toDoubleFunction = (integer) -> (double) integer;
    ToIntBiFunction<String, Integer> toIntBiFunction = (string, integer) -> string.length() + integer;
    ToIntFunction<String> toIntFunction = String::length;
    ToLongBiFunction<String, Integer> toLongBiFunction = (string, integer) -> (long) (string.length() + integer);
    ToLongFunction<Integer> toLongFunction = (integer) -> (long) integer;

    /** Les predicates servent à retourner un boolean
     */
    Predicate<String> predicate = (string) -> string.contains("AZERTY");
    DoublePredicate doublePredicate = (doubled) -> doubled > 10.0;
    IntPredicate intPredicate = (integer) -> integer > 10;
    LongPredicate longPredicate = (lonG) -> lonG > 1L;
    BiPredicate<String, Integer> biPredicate = (string, integer) -> string.length() > integer;

    /** Les Supplier servent a retourner une valeur
     */
    Supplier<String> supplier = () -> "String";
    BooleanSupplier booleanSupplier = () -> true;
    IntSupplier intSupplier = () -> 1;
    DoubleSupplier doubleSupplier = () -> 1.0;
    LongSupplier longSupplier = () -> 1L;
}
