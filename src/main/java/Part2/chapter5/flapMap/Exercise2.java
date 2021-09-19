package Part2.chapter5.flapMap;

import java.util.logging.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
2. Given two lists of numbers, how would you return all pairs of numbers? For example,
given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4),
(3, 3), (3, 4)]. For simplicity, you can represent a pair as an array with two elements.
 */
public class Exercise2 {
    private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.Utilidades");
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(Collectors.toList());
        List<String> result = pairs.stream().map(Arrays::toString).collect(Collectors.toList());
        System.out.println(result);
    }
}
