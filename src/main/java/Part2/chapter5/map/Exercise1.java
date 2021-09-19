package Part2.chapter5.map;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/*
1. Given a list of numbers, how would you return a list of the square of each number?
For example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
 */
public class Exercise1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares =
                numbers.stream()
                        .map(n -> n * n)
                        .collect(toList());
        System.out.println(squares);

        List<Integer> numbers2 = Arrays.asList(1, 2, 2, 3, 4, 5, 1, 1, 1);
        List<Integer> result = new ArrayList<>();
        int x = 0;
        for (int i = 0; i < numbers2.size(); i++) {
               if (x != numbers2.get(i)){
                   result.add( numbers2.get(i));
               }
               x = numbers2.get(i);
        }
        System.out.println(result);
        List<String> strings = Arrays.asList("A", "A", "A", "B", "B", "A", "A", "A", "C", "C", "C", "A", "A", "B", "B", "A");
        List<Integer> request = Arrays.asList(1, 2, 2, 3, 4, 5, 1, 1, 1);
        List<Integer> response = IntStream.range(0, request.size())
                .filter(i->i ==0 || !request.get(i).equals(request.get(i-1)))
                .mapToObj(request::get)
                .collect(Collectors.toList());
        System.out.println(response);


    }
}