package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("I am writing in " + Thread.currentThread().getName() + " thread");

        MyThread thread = new MyThread();
        thread.start();

        System.out.println("main function has done all the work");
    }

    private static class MyThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am writing in " + currentThread().getName() + " thread");
        }
    }

}
