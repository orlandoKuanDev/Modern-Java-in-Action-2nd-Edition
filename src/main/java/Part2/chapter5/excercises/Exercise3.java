package Part2.chapter5.excercises;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {
    public static void main(String[] args) {
        List<Transaction> transactions = Data.getTransaction();
        List<Trader> result = transactions.stream()
                .map(Transaction::getTrader)
                .filter(f -> f.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
