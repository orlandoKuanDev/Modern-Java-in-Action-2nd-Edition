package Part2.chapter5.excercises;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Exercise1 {
    public static void main(String[] args) {
        List<Transaction> transactions = Data.getTransaction();
        List<Transaction> result = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue)) //order by value
                .collect(toList());
        System.out.println(result);
    }
}
