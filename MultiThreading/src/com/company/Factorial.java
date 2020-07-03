package com.company;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[]args){
        // jan 1 1970
        long start = System.currentTimeMillis();
//        int[]arr = {10000, 20000, 12000, 50000, 30000, 4000, 6000, 32324, 26347, 25634};
//
        int[]arr = {10000, 20000, 12000, 50000, 30000, 4000, 6000, 32324, 26347, 25634, 4563, 5426, 5263, 54263, 4526, 4323, 4526};


        for(int i=0;i<arr.length; i++){
            System.out.println(calculate(arr[i]));
        }
        // 191844

        System.out.println("time taken to execute " + (System.currentTimeMillis() - start));
    }

    public static BigInteger calculate(int num){
        BigInteger bi = BigInteger.valueOf(1);
        for(int i = 2; i <= num; i++){
            bi = bi.multiply(BigInteger.valueOf(i));
        }

        return bi;
    }
}
