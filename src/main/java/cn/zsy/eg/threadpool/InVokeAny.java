package cn.zsy.eg.threadpool;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InVokeAny {

  /**
   * inVokeAny()
   方法 invokeAny() 接收壹個包含 Callable 对象的集合作为参数。调用该方法不会返回 Future 对象，而是返回集合中某壹個 Callable
   对象的结果，而且无法保证调用之后返回的结果是哪壹個 Callable，只知道它是这些 Callable 中壹個执行结束的 Callable 对象。
   * @param args
   * @throws ExecutionException
   * @throws InterruptedException
   */
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    Set<Callable<String>> callables = new HashSet<Callable<String>>();

    callables.add(new Callable<String>() {
      @Override
      public String call() throws Exception {
        System.out.println("Task 1");
        return "Task 1";
      }
    });
    callables.add(new Callable<String>() {
      @Override
      public String call() throws Exception {
        System.out.println("Task 2");
        return "Task 2";
      }
    });
    callables.add(new Callable<String>() {
      @Override
      public String call() throws Exception {
        System.out.println("Task 3");
        return "Task 3";
      }
    });

    String result = executorService.invokeAny(callables);

    System.out.println("result = " + result);

    executorService.shutdown();
  }

}
