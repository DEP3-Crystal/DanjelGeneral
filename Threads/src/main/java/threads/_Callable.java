package threads;

import java.util.concurrent.*;

public class _Callable {
    static int count = 0;

    public static void increment() {
        count++;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Future<Integer> future = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    increment();
                }
                return count;
            }
        });
        Future<Integer> future1 = pool.submit(() ->
        {
            for (int i = 0; i < 100; i++) {
                increment();
            }
            return count;
        });
        pool.shutdown();

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
