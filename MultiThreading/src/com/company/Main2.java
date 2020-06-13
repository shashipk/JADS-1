package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

import java.rmi.server.ExportException;
import java.sql.SQLException;

public class Main2 {

    public static void main(String[]args) throws InterruptedException {

        MyThread o = new MyThread();
        Thread thread = new Thread(o);
        thread.start();
        System.out.println("I am writing in " + Thread.currentThread().getName() + " thread");

    }

    private static class MyThread extends Animal implements Runnable {

        @Override
        public void run(){
            try {
                Thread.sleep(30000);
//                throw new InternalException("some exception");
                System.out.println("I am writing in " + Thread.currentThread().getName() + " thread");
                throw new SQLException();
            } catch (InterruptedException e) {
//                e.printStackTrace();
                System.out.println("sleep interrupted " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
            }catch (SQLException e){
                System.out.println("sql exception occured");
            }catch (Exception e){
                System.out.println("some error encountered");
            }
            finally {
                System.out.println("whatever happened, i am just quitting..");
            }
        }
    }
}
