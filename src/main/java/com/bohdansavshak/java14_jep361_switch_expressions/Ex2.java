package com.bohdansavshak.java14_jep361_switch_expressions;

public class Ex2 {
    public static void main(String[] args) {
        enum Season {
            WINTER, SPRING, SUMMER, AUTUMN
        }

        var season = Season.SUMMER;

        // default switch statement with fallthrough
        switch (season) {
            case WINTER:
                System.out.println("Winter");
                break;
            case SUMMER:
                System.out.println("Summer");
                break;
        }

        // switch statement with arrow label
        switch (season) {
            case WINTER -> System.out.println("Winter");
            case SUMMER -> System.out.println("Summer");
        }

        // switch expression THE MOST COMMON SCENARIO
        int value = switch (season) {
            case WINTER -> 1;
            case SUMMER -> 2;
            case SPRING -> 3;
            case AUTUMN -> 4;
        };
        System.out.println(value);

        // switch expression with fallthrough
        int val2 = switch (season) {
            case WINTER: yield 1;
            case SUMMER: yield 2;
            case SPRING: yield 3;
            case AUTUMN: yield 4;
        };
        System.out.println(val2);


    }
}
