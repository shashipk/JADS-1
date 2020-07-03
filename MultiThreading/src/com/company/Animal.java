package com.company;

public class Animal {

    public static void main(String[]args){
        System.out.println("in main function..");
        func1();

        System.out.println("closing app...");
    }

    public static void func1(){

        System.out.println("in func1 function..");
        func2();
    }

    public static void func2(){

        System.out.println("in func2 function..");
    }

}
