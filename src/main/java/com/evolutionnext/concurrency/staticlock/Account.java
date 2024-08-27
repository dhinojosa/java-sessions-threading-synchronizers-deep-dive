package com.evolutionnext.concurrency.staticlock;

class Account {
    private int amount;

    public Account() {
    }

    //The static makes the class become the lock
    public void deposit(int amount) {
//        synchronized (this) {
            System.out.format("Thread %s, Amount: %d%n", Thread.currentThread(), amount);
            this.amount = amount;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }
    }

    public int getAmount() {
        synchronized (this) {
            return amount;
        }
    }

    public static void main(String[] args) {
        Account a = new Account();
        Thread t = new Thread(() ->  a.deposit(100));
        Thread t1 = new Thread(() -> a.deposit(200));
        Thread t2 = new Thread(() -> a.deposit(300));
        Thread t3 = new Thread(() -> a.deposit(400));
        Thread t4 = new Thread(() -> a.deposit(500));
        t.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println(a.getAmount());
    }
}
