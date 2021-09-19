package Part2.chapter5.excercises;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

public class Exercise7 {
    public static void main(String[] args) {
        List<Transaction> transactions = Data.getTransaction();
        Integer result = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(0, (t, tMin) -> t < tMin && t != 0 ? t : tMin);
        System.out.println(result);
        Optional<Transaction> smallestTransaction = transactions.stream()
                .reduce((t1, t2) ->
                        t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(smallestTransaction);
        //Optimize
        Optional<Transaction> smallestTransaction2 =
                transactions.stream()
                        .min(comparing(Transaction::getValue));
        System.out.println(smallestTransaction2);
    }
}
