package com.sparta.rp;

public class ThreadJoin {
    static class Joins implements Runnable{
        @Override
        public void run() {
            for(int i = 1; i <= 5 ; i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " +  i);
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Joins());
        thread1.setName("Thread 1");

        Thread thread2 = new Thread(new Joins());
        thread2.setName("Thread 2");

        Thread thread3 = new Thread(new Joins());
        thread3.setName("Thread 3");

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
