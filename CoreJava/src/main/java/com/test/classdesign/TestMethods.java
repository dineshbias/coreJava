/**
 * 
 */
package com.test.classdesign;

/**
 * @author edinjos
 *
 */
public class TestMethods {

  /**
   * 
   */
  public TestMethods() {
    System.out.println("Constructor TestMethods");
  }

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) {

    String s = "next";
    String s2 = "next 1".substring(0, 4).toString();
    System.out.println(s == s2);
    System.out.println(s.equals(s2));

    String s3 = "a" + "bc";
    String s4 = "ab" + "c";
    System.out.println(s3 == s4);
    System.out.println(s3.equals(s4));
    String s5 = new String(s3);
    System.out.println("s5: " + s3 == s5);
    System.out.println("s5: " + s3.equals(s5));

    System.out.println("----------------Base class variable and subclass object------------------");
    TOB tb1 = new TOS();
    tb1.test1();
    try {
      tb1.test2(new TU());
    } catch (XException e1) {
      e1.printStackTrace();
    }
    tb1.test3();
    System.out.println("----");

    System.out.println("----------------Base class variable and baseClass object------------------");
    TOB tb2 = new TOB();
    tb2.test1();
    try {
      tb2.test2(new TU());
    } catch (XException e1) {
      e1.printStackTrace();
    }
    tb2.test3();
    System.out.println("----------------Base class variable typecasted and superClass object------------------");
    TOB tb3 = new TOS();
    ((TOS) tb3).test1();
    try {
      ((TOS) tb3).test2(new TU());
    } catch (XYException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    ((TOS) tb3).test3();
    System.out.println("----");

    com.test.basic.baseClass tb;
    Bird b = new Eagle();
    Eagle e = (Eagle) b;

    String[] animals = new String[0];
    System.out.println(animals.length);

    b.printNonStaticX(); // printNonStaticX true
    b.printStaticX(); // printStaticX false
    System.out.println();
    e.printNonStaticX();// printNonStaticX true
    e.printStaticX();// printStaticX false
    e.printNonStaticY();// printNonStaticY true
    e.printStaticY();// printStaticY true
    try {
      setNumberEggs(-7);

    } catch (Exception e3) {
      System.out.println("Exception catch");
    } catch (Error e2) {
      System.out.println("Error catch");
    } finally {

      System.out.println("finally");
    }

  }

  public static void setNumberEggs(int count) {
    throw new Error();
  }

}
