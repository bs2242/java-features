package com.bohdansavshak.bobocode.memory;

public class StackOverflowErrorCode {
    public static void main(String[] args) {
        hello(10);
    }

    public static void hello(int i) {
        hello(i);
    }
}
