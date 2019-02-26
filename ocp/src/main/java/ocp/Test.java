package ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import ocp.oops.SampleA;

public class Test {
  public static void calculateFuture(int seed) {
    // IMPLEMENTATION OMITTED
  }

  public static void seeFuture(Future<?> f) {

    SampleA test = new SampleA();
    System.out.println(test.sPublic);

    try {
      Object obj = f.get(100, TimeUnit.DAYS);

      System.out.println(obj); // i1
    } catch (Exception e) {
      System.out.println("Problem");
    }
  }

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    X x1 = new X();
    X x2 = new X();

    System.out.println(X.class);
    System.out.println(x1.getClass() + " " + x2.getClass());

    String className = "ocp.oops.test.Temp";
    try {
      Class cls = Class.forName(className);
      ocp.oops.test.X obj = (ocp.oops.test.X) cls.newInstance();
      System.out.println(obj);
      obj.setsDefault("Default Test");
      obj.setsPrivate("Private Test");
      obj.setsProtected("Protected Test");
      obj.setsPublic("Public Test");
      System.out.println(obj);
      System.out
          .println(obj.getsDefault() + " " + obj.getsPrivate() + " " + obj.getsProtected() + " " + obj.getsPublic());
    } catch (ClassNotFoundException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (InstantiationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    ExecutorService service = Executors.newSingleThreadExecutor();
    final List<Future<?>> results = new ArrayList<>();
    IntStream.range(10, 15).forEach(i -> results.add(service.submit(() -> calculateFuture(i)))); // i2
    results.stream().forEach(f -> seeFuture(f));
    service.shutdown();
  }
}

class X extends SampleA {

  public void testAccess() {
    // System.out.println(sDefault);
    System.out.println(sProtected);
    System.out.println(sPublic);
  }

}