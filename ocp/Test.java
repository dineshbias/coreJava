package ocp;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class Test {
   public static void calculateFuture(int seed) {
      // IMPLEMENTATION OMITTED
   }

   public static void seeFuture(Future<?> f) {
      try {
    	  Object obj = f.get(100, TimeUnit.DAYS);
    	  
         System.out.println(obj); // i1
      } catch (Exception e) {
         System.out.println("Problem");
      }
   }

   public static void main(String[] args) throws InterruptedException, ExecutionException {
      ExecutorService service = Executors.newSingleThreadExecutor();
      final List<Future<?>> results = new ArrayList<>();
      IntStream.range(10, 15)
         .forEach(i -> results.add(
            service.submit(() -> calculateFuture(i)))); // i2
      results.stream().forEach(f -> seeFuture(f));
      service.shutdown();
   }
}