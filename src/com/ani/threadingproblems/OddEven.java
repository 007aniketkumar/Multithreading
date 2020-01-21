package com.ani.threadingproblems;


/**
 *
 * Given 2 threads :
 * T1 Printing even numbers and
 * T2 Printing odd numbers
 *
 * print the numbers 1-10
 *
 *
 */

public class OddEven {

int initialNumber =1;


    synchronized void evenNumbers()  {
        while(initialNumber<=10) {
            if (initialNumber % 2 == 0) {
                System.out.println("even:" + initialNumber);
                initialNumber++;

            } else {

            //odd number encountered
            //notify all the existing threads
            notify();
            //wait this thread
            try {
                System.out.println("even waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } }notify();}



    synchronized void oddNumbers() {


        while (initialNumber<=10) {
            if (initialNumber % 2 != 0) {
                System.out.println("odd :" + initialNumber);
                initialNumber++;
            } else {

            //even number encountered

            notify();
            try {
                System.out.println("odd waiting");

                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } }
    }

    public static void main(String[] args){
        OddEven obj = new OddEven();

        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.evenNumbers();
            }
        }
        );
      Thread oddThread = new Thread(new Runnable() {
          @Override
          public void run() {
              obj.oddNumbers();
          }
      });



      evenThread.start();
      oddThread.start();
    }

}
