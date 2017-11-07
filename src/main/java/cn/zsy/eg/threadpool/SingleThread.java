package cn.zsy.eg.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThread {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    executorService.execute(new Runnable() {
      @Override
      public void run() {
        System.out.println("Asynchronous task 1..");
      }
    });

    executorService.execute(new Runnable() {
      @Override
      public void run() {
        System.out.println("Asynchronous task 3..");
      }
    });


    executorService.execute(new Runnable() {
      @Override
      public void run() {
        System.out.println("Asynchronous task 2..");
      }
    });



    executorService.shutdown();
  }

}
