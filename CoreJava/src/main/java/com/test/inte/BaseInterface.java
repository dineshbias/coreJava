/**
 * 
 */
package com.test.inte;

/**
 * @author edinjos
 *
 */
public interface BaseInterface {
  int constant = 1;

  static public void test() {
    System.out.println("BaseInterface test");
  }

  default public void Abc() {
    System.out.println("BaseInterface test");
  }

  default public void test2() {
    System.out.println("BaseInterface test");
  }

  default public void test3() {
    System.out.println("BaseInterface test");
  }
}
