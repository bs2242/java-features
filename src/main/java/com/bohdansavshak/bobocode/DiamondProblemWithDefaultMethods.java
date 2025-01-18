package com.bohdansavshak.bobocode;

interface I {
  default void m() {}
}

interface I2 {
  default void m() {}
}

public class DiamondProblemWithDefaultMethods {
  public I hello() {
    System.out.println("Hello");
    return new A();
  }
}

class A implements I, I2 {
  @Override
  public void m() {
    I2.super.m();
  }
}
