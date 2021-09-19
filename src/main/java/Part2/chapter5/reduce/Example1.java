package Part2.chapter5.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
/**
 *
 * You need a lambda that, given two elements, returns
 * the maximum of them
 */
public class Example1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println(min);
        Integer  max_old = numbers
                .stream()
                .reduce(0, (x, y) -> x < y && x != 0 ? x : y);
        System.out.println(max_old);
    }
}
