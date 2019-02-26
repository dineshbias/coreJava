/**
 * 
 */
package ocp.gc;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author dinesh.joshi
 *
 */
public class TestGarbageCollection {

  private static Collection<TestGC> objects;

  public static void main(String... strings) throws InterruptedException {
    objects = new ArrayList<TestGC>();
    for (int i = 0;; i++) {
      TestGC obj = new TestGC(i, "TestString", (float) 10.4);
      objects.add(obj);
      obj.addOobjects(obj);
      // Thread.sleep(100);
    }

  }

}

class TestGC {

  private Collection<TestGC> objects;

  private Integer i;
  private String s;
  private Float f;

  public TestGC(Integer i, String s, Float f) {
    super();
    this.i = i;
    this.s = s;
    this.f = f;

  }

  public void addOobjects(TestGC object) {
    if (null == objects) {
      objects = new ArrayList<TestGC>();
    }
    objects.add(object);
  }
}