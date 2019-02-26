/**
 * 
 */
package ocp.play.fun;

/**
 * @author dinesh.joshi
 *
 */
public class TestPassByValueAndRefrence {

  public static void main(String... args) {
    Test t1 = new Test(1, "One");
    Test t2 = new Test(2, "Two");
    System.out.println(t1 + " " + t2);
    swap(t1, t2);
    System.out.println(t1 + " " + t2);
    swapJava(t1, t2);
    System.out.println(t1 + " " + t2);
  }

  public static void swap(Test t1, Test t2) {
    Test t3 = t1;
    t1 = t2;
    t2 = t3;
    System.out.println("Swap:" + t1 + " " + t2);
  }

  public static void swapJava(Test t1, Test t2) {
    Test t3 = new Test(t1.getI(), t1.getS());
    t1.setI(t2.getI());
    t1.setS(t2.getS());
    t2.setI(t3.getI());
    t2.setS(t3.getS());
    System.out.println("swapJava:" + t1 + " " + t2);
  }

}

class Test {
  private int i;
  private String s;

  public int getI() {
    return i;
  }

  public void setI(int i) {
    this.i = i;
  }

  public String getS() {
    return s;
  }

  public void setS(String s) {
    this.s = s;
  }

  public Test(int i, String s) {
    super();
    this.i = i;
    this.s = s;
  }

  @Override
  public String toString() {
    return "Test [i=" + i + ", s=" + s + "]";
  }

}