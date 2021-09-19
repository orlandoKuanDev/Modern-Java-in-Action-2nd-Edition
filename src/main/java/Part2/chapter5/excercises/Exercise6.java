package Part2.chapter5.excercises;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise6 {
    public static void main(String[] args) {
        List<Transaction> transactions = Data.getTransaction();
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }
}
