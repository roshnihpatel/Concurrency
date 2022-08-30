package com.sparta.rp;

public class ThreadBasics implements Runnable{
    @Override
    public void run() {
        System.out.println("I am printing from a thread");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadBasics());
        Thread thread2 = new Thread(() -> System.out.println("Do something"));
        thread.start();
        thread2.start();

    }
}
