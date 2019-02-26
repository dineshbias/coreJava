package com.test.classdesign;

public class TOS extends TOB {

  private int i = 10000001;
  private static int j = 10000001;

  @Override
  public void test1() {
    System.out.println("TOS:  test1 " + i);
  }

  @Override
  protected TUV test2(TU test) throws XYException {
    System.out.println("TOS: test2 " + i);
    throw new XYException();

  }

  public static void test3() {
    System.out.println("TOS static : test3 " + j);
  }

}

class XException extends Exception {

}

class XYException extends XException {

}
