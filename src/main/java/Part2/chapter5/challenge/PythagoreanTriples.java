package Part2.chapter5.challenge;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * What’s a Pythagorean triple? We have to go back a few years in the past. In one of your
 * exciting math classes, you learned that the famous Greek mathematician Pythagoras
 * discovered that certain triples of numbers (a, b, c) satisfy the formula a * a + b * b =
 * c * c where a , b , and c are integers. For example, (3, 4, 5) is a valid Pythagorean triple
 * because 3 * 3 + 4 * 4 = 5 * 5 or 9 + 16 = 25. There are an infinite number of such tri-
 * ples. For example, (5, 12, 13), (6, 8, 10), and (7, 24, 25) are all valid Pythagorean tri-
 * ples.
 */
public class PythagoreanTriples {
    public static void main(String[] args) {
        Supplier<Stream<int[]>> pythagoreanTriples = () -> IntStream
                        .rangeClosed(1, 100)
                        .boxed()
                        .flatMap(a -> IntStream //stream of streams
                                        .rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                        .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                        );
        /*
        flatMap method does the mapping and also flattens all the generated streams of triples into a
        single stream
         */
        pythagoreanTriples.get().limit(5)
                .forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        /*
         * Error: Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
         * Cause: En Java 8, cada Stream clase representa una secuencia de datos de un solo uso y admite varias operaciones de E / S.
         * Description: Una corriente debe ser operado en (invocando una operación corriente intermedia o terminal) sólo una vez. Una implementación de Stream puede generar    IllegalStateException si detecta que el Stream se está reutilizando.
         */
        System.out.println(pythagoreanTriples.get().map(Arrays::toString).collect(Collectors.toList()));


        //optimize
        Stream<double[]> pythagoreanTriples2 =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .mapToObj(
                                                b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
                        .filter(t -> t[2] % 1 == 0));
        System.out.println(pythagoreanTriples2.map(Arrays::toString).collect(Collectors.toList()));
    }
}
