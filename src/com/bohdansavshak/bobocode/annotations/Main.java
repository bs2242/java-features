package com.bohdansavshak.bobocode.annotations;

@Marker("Hello World")
public class Main {

    public static void main(String[] args) {
        Marker annotation = Main.class.getAnnotation(Marker.class);
        System.out.println(annotation.value());
    }
}
