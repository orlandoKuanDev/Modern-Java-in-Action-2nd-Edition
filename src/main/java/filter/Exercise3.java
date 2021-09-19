package filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/*
3. How would you extend the previous example to return only pairs whose sum is
divisible by 3?
 */
/*
Answer:
You saw earlier that filter can be used with a predicate to filter elements from a
stream. Because after the flatMap operation you have a stream of int[] that rep-
resent a pair, you only need a predicate to check if the sum is divisible by 3:
 */
public class Exercise3 {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i ->
                                numbers2.stream()
                                        .filter(j -> (i + j) % 3 == 0)
                                        .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        List<String> result = pairs.stream().map(Arrays::toString).collect(Collectors.toList());
        System.out.println(result);
    }
}
