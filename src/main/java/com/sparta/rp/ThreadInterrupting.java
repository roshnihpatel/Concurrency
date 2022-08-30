package com.sparta.rp;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreadInterrupting {
    private static class Turtles implements Runnable {
        @Override
        public void run() {
            ArrayList<String> turtles = new ArrayList<>(Arrays.asList("Leonardo", "Michelangelo", "Donatello", "Raphael"));
            try {
                for (String turtle: turtles) {
                    Thread.sleep(2000);
                    System.out.println(Util.getThreadName() + ": " + turtle);
                }
            } catch (InterruptedException e) {
                System.err.println("Turtles has been interrupted");
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        long waitTime = 25000;
        long startTime = System.currentTimeMillis();
        System.out.println(Util.getThreadName() + " has started");
        Thread turtles = new Thread(new Turtles());
        turtles.start();
        while (turtles.isAlive()) {
            System.out.println(Util.getThreadName() + " is waiting");
            try {
                turtles.join(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(((System.currentTimeMillis() - startTime) > waitTime && turtles.isAlive())) {
                System.out.println(Util.getThreadName() + " is tired of waiting!");
                turtles.interrupt();
                try {
                    turtles.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
