package cn.zsy.eg.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThread {

    /**
     * https://my.oschina.net/bairrfhoinn/blog/177639
     * https://my.oschina.net/bairrfhoinn/blog/177639
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(() -> System.out.println("Asynchronous task 1.."));
        executorService.execute(() -> System.out.println("Asynchronous task 2.."));
        executorService.execute(() -> System.out.println("Asynchronous task 3.."));
        executorService.execute(() -> System.out.println("Asynchronous task 4.."));
        executorService.execute(() -> System.out.println("Asynchronous task 5.."));
        executorService.execute(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Asynchronous task 6..");
        });

        Future future = executorService.submit(() -> System.out.println("Asynchronous task 7"));
        //如果任务结束执行则返回 null
        try {
            System.out.println("future.get()=" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Future futureA = executorService.submit(() -> {
            System.out.println("Asynchronous Callable");
            return "Callable Result";
        });

        try {
            System.out.println("future.get() = " + futureA.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();


    }
}
