package Part2.chapter5.excercises;

import java.util.List;

public class Exercise5 {
    public static void main(String[] args) {
        List<Transaction> transactions = Data.getTransaction();
        boolean milanBased = transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                .getCity()
                                .equals("Milan"));
        System.out.println(milanBased);
    }
}
