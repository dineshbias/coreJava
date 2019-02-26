/**
 * 
 */
package ocp.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dinesh.joshi
 *
 */
public class TestMemoryErrors {

  public static void main(String[] args) {

    test3();
    // test2();
    // test1();

    System.out.println("exit...");
  }

  private static void test3() {
    test3();
  }

  private static void test2() {
    for (int i = 0;; i += 1000000000) {
      System.out.println(i);
    }
  }

  private static void test1() {
    try {

      Sample s = new Sample();

    } finally {
      System.out.println("test2..");
    }
  }

  private static void test4() {
    ExecutorService es = Executors.newSingleThreadExecutor();
    Test t = new Test("Test");
    System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " running...");
    try {
      es.execute(() -> t.test());
    } catch (Error e) {
      System.out.println(e);
    } finally {

      System.out.println("finally...");
      es.shutdown();
    }
  }
}

class Sample {
  Integer x;
  Float y;
  String s;

  List<Integer> l;

  Sample() {
    x = new Integer(10);
    y = new Float(3.13);
    s = new String("Test");
    l = new ArrayList<>();
    for (int i = 0;; i++) {
      // x = new Integer(i);
      System.out.println("&&");
      l.add(x);
    }
  }
}
