package com.bohdansavshak.java16_jep395_records;

public class Main2 {
    public static void main(String[] args) {
        Main.Point<Double> doublePoint = new Main.Point<>(1.0, 1.0);
        doublePoint.publicHello();
    }
}
