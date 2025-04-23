package com.basejava.webapp;

public class DeadlockDemo {
    public static void createDeadlock(final Object firstLock, final Object secondLock) {
        Thread thread = new Thread(() -> {
            System.out.println("Waiting " + firstLock);
            synchronized (firstLock) {
                System.out.println("Holding " + firstLock);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Waiting " + secondLock);
                synchronized (secondLock) {
                    System.out.println("Holding " + secondLock);
                }
            }
        });
        thread.start();
    }
}