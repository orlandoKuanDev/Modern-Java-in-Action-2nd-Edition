package Part2.chapter5.StateLess;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;


public class Example1 {
    public static void main(String[] args) {
        String str = "my name is fangshixiang";
       /* Stream.of(str.split(" "))
                .peek(x -> System.out.println(Thread.currentThread().getName() + "___" + x))
                .map(x -> x.length())
                .count();*/

        ForkJoinPool pool = new ForkJoinPool(10);

        pool.execute(() -> Stream.of(str.split(" "))
                .parallel()
                .peek(x -> System.out.println(Thread.currentThread().getName() + "___" + x))
                .map(x -> x.length())
                .count());
        pool.shutdown();

        synchronized (pool) {
            try {
                pool.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
