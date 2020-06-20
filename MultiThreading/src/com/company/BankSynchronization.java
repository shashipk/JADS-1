package com.company;

public class BankSynchronization {

    public static void main(String[]args) throws InterruptedException {

        BankObj obj1 = new BankObj(1, 300);
        BankObj obj2 = new BankObj(2, 100);

        MyThread[]threads = new MyThread[6];
        threads[0] = new MyThread(obj1, true, 50);
        threads[1] = new MyThread(obj1, false, 100);
        threads[2] = new MyThread(obj1, true, 150);

        threads[3] = new MyThread(obj2, false, 100);
        threads[4] = new MyThread(obj2, true, 300);
        threads[5] = new MyThread(obj2, false, 150);

        for(int i=0;i<6;i++){
            threads[i].start();
        }

        for(int i=0;i<6;i++){
            threads[i].join();
        }

        System.out.println("bank balance of obj 1 " + obj1.getBalance() + ", bank balance of obj 2 " + obj2.getBalance());
    }

    private static class MyThread extends Thread{

        private BankObj obj;
        private boolean isDeposit;
        private int amount;

        public MyThread(BankObj obj, boolean isDeposit, int amount) {
            this.obj = obj;
            this.isDeposit = isDeposit;
            this.amount = amount;
        }

        @Override
        public void run() {
            if(this.isDeposit){
                try {
                    deposit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    withdraw();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void deposit() throws InterruptedException {
            // gcbjkghjbdnkj

            synchronized (BankObj.class) {
                System.out.println("In start of deposit function of thread : " + currentThread().getName() + ", bankObj is " + this.obj);
//                Thread.sleep(20000);
                int prev_bal = this.obj.getBalance();
                this.obj.setBalance(prev_bal + this.amount);
                System.out.println("In end of deposit function of thread : " + currentThread().getName() + ", bankObj is " + this.obj);

            }

            // deyxhkjf


        }

        public void withdraw() throws InterruptedException {
            synchronized (BankObj.class) {
                System.out.println("In start of withdraw function of thread : " + currentThread().getName() + ", bankObj is " + this.obj);
//                Thread.sleep(20000);
                int prev_bal = this.obj.getBalance();
                this.obj.setBalance(prev_bal - this.amount);
                System.out.println("In end of withraw function of thread : " + currentThread().getName() + ", bankObj is " + this.obj);

            }
        }


    }


}
