package Part2.chapter5.excercises;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Exercise4 {
    public static void main(String[] args) {
        List<Transaction> transactions = Data.getTransaction();
        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderStr);
        //Optimize
        String traderStr2 = transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(joining());
        System.out.println(traderStr2);
    }
}
