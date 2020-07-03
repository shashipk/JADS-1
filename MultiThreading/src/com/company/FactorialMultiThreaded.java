package com.company;

import java.math.BigInteger;

public class FactorialMultiThreaded {

    public static void main(String[]args) throws InterruptedException {

//        int[]arr = {10000, 20000, 12000, 50000, 30000, 40000, 67000, 326324, 256347, 25634};
        int[]arr = {10000, 20000, 12000, 50000, 30000, 4000, 6000, 32324, 26347, 25634, 4563, 5426, 5263, 54263, 4526, 4323, 4526};
        MyThread[] threads = new MyThread[arr.length];

        long start = System.currentTimeMillis();

        for(int i=0;i<threads.length; i++){
            threads[i] = new MyThread(arr[i]);
            threads[i].start();
        }

        for(int i=0;i<threads.length;i++){
            threads[i].join();
        }

        for(int i=0;i<threads.length;i++){
            System.out.println("for no. " + threads[i].num + ", result = " + threads[i].result);
        }

        System.out.println("time taken to execute " + (System.currentTimeMillis() - start));
    }

    private static class MyThread extends Thread{

        private int num;
        private BigInteger result;

        public MyThread(int num) {
            this.num = num;
            this.result = BigInteger.valueOf(1);
        }

        @Override
        public void run() {
            calculate();
        }

        public void calculate(){
            for(int i = 2; i <= this.num; i++){
                this.result = this.result.multiply(BigInteger.valueOf(i));
            }
        }
    }
}
