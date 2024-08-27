package com.evolutionnext.concurrency;

import java.util.concurrent.*;

public class NoRespectFuture {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Future<Integer> future = cachedThreadPool.submit(() -> {
            //Sleep for 4000 milliseconds
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted");
                e.printStackTrace();
            }
            return 90 + 10;
        });

        Integer i = future.get(2, TimeUnit.SECONDS);
        System.out.println(i);
    }
}
