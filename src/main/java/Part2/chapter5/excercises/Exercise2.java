package Part2.chapter5.excercises;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {
    public static void main(String[] args) {
        List<Transaction> transactions = Data.getTransaction();
        List<String> result = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
