package com.doak.springbootMybatisdemo.thread.lock;

import javax.naming.InsufficientResourcesException;
import java.util.Random;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2020/4/5 10:42
 * @description：证明通过hashcode也会死锁
 */
public class DemonstrateDeadLock {
    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNTS = 5;
    private static final int NUM_ITERATIONS = 1000000;
    private static final Random random = new Random();
    private static final Account[] accounts = new Account[NUM_ACCOUNTS];

    private static final Object tieLock = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(10000);
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            new TransferThread().start();
        }

    }

    public static void transferMoney(final Account fromAcct, final Account toAcct, final int amount)
            throws InsufficientResourcesException {
        class Helper {
            public void transfer() throws InsufficientResourcesException {
                /*if (fromAcct.get() < amount) {
                    throw new InsufficientResourcesException();
                } else {
                    fromAcct.debit(amount);
                    toAcct.credit(amount);
                }*/
                fromAcct.debit(amount);
                toAcct.credit(amount);
            }
        }

        // 转账双方共用这两个账户的对象，否则无法通过下面方式排序下面的锁顺序
        int fromHash = System.identityHashCode(fromAcct);
        int toHash = System.identityHashCode(toAcct);

        if (fromHash < toHash) {
            synchronized (fromAcct) {
                synchronized (toAcct) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAcct) {
                synchronized (fromAcct) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAcct) {
                    synchronized (toAcct) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }

    static class TransferThread extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < NUM_ITERATIONS; i++) {
                    int fromAcc = random.nextInt(NUM_ACCOUNTS);
                    int toAcc = random.nextInt(NUM_ACCOUNTS);
                    int amount = random.nextInt(1000);
                    transferMoney(accounts[fromAcc], accounts[toAcc], amount);
                }
            } catch (InsufficientResourcesException e) {
                System.out.println("操作失败");
            }
        }

    }

    static class Account {
        private int money;

        public Account(int money) {
            this.money = money;
        }

        public void debit(int amount) {
            System.out.println("after debit " + amount + " " + this.money + " -> " + (this.money - amount));
            this.money -= amount;
        }

        public void credit(int amount) {
            System.out.println("after credit " + amount + " " + this.money + " -> " + (this.money + amount));
            this.money += amount;
        }

        public int get() {
            return this.money;
        }
    }
}
