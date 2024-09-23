package com.bohdansavshak.bobocode;

public class DiamondProblemWithDefaultMethods {
    public I hello() {
        System.out.println("Hello");
        return new A();
    }
}

interface I {
    default void m() {

    }
}

interface I2 {
    default void m() {

    }
}

class A implements I, I2 {
    @Override
    public void m() {
        I2.super.m();
    }
}
