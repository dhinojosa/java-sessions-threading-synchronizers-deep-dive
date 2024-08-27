package com.evolutionnext.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierRunner {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.println("Done");
        });

        Thread t1 = new Thread(new MyRunnable(cyclicBarrier, "A"));
        Thread t2 = new Thread(new MyRunnable(cyclicBarrier, "B"));
        Thread t3 = new Thread(new MyRunnable(cyclicBarrier, "C"));
        Thread t4 = new Thread(new MyRunnable(cyclicBarrier, "D"));
        Thread t5 = new Thread(new MyRunnable(cyclicBarrier, "E"));
        Thread t6 = new Thread(new MyRunnable(cyclicBarrier, "F"));
        Thread t7 = new Thread(new MyRunnable(cyclicBarrier, "G"));
        Thread t8 = new Thread(new MyRunnable(cyclicBarrier, "H"));
        Thread t9 = new Thread(new MyRunnable(cyclicBarrier, "I"));
        Thread t10 = new Thread(new MyRunnable(cyclicBarrier, "J"));
        Thread t11 = new Thread(new MyRunnable(cyclicBarrier, "K"));
        Thread t12 = new Thread(new MyRunnable(cyclicBarrier, "L"));


        Thread daemonReporter = new Thread(() -> {
            while (true) {
                System.out.printf("Cyclic Barrier says: parties: %d, waiting: %d%n",
                    cyclicBarrier.getParties(),
                    cyclicBarrier.getNumberWaiting());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }   
            }
        });
        
        daemonReporter.setDaemon(true);
        daemonReporter.start();
        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t3.start();
        Thread.sleep(1000);
        t4.start();
        Thread.sleep(1000);
        t5.start();
        Thread.sleep(1000);
        t6.start();
        Thread.sleep(1000);
        t7.start();
        Thread.sleep(1000);
        t8.start();
        Thread.sleep(1000);
        t9.start();
        Thread.sleep(1000);
        t10.start();
        Thread.sleep(1000);
        t11.start();
        Thread.sleep(1000);
        t12.start();
        Thread.sleep(1000);
    }
}
