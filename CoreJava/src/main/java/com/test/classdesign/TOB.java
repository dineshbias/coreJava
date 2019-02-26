package com.test.classdesign;

public class TOB {

  private int i = 10;
  private static int j = 10;

  public void test1() {
    System.out.println("TOB:  test1 " + i);
  }

  protected TU test2(TU test) throws XException {
    System.out.println("TOB: test2 " + i);
    return new TU();
  }

  public static void test3() {
    System.out.println("TOB static : test3 " + j);
  }

}

class T {

}

class TU extends T {

}

class TUV extends TU {

}