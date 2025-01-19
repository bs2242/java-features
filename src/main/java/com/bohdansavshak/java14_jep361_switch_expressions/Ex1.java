package com.bohdansavshak.java14_jep361_switch_expressions;

public class Ex1 {
    void main() {
        var a = MyEnum.A;

        var result =
                switch (a) {
                    case A -> "A";
                    case B, C -> "B and C";
                };

        // each case have its own scope so you can define multiple variables temp.
        var result1 =
                switch (a) {
                    case A -> {
                        var temp = "temp";
                        yield "A";
                    }
                    case B, C -> {
                        var temp = "temp";
                        yield "B and C";
                    }
                };

        // two expressions
        var res =
                switch (a) {
                    case A -> {
                        yield "hello";
                    }
                    case B -> {
                        yield "sldkfj";
                    }
                    default -> "C";
                };

        var res1 =
                switch (a) {
                    case A: {
                        yield "hello";
                    }
                    case B: {
                        yield "sldkfj";
                    }
                    case C: {
                        yield "C";
                    }
                };

        // two statements
        // statements aren't exhaustive as expressions
        switch (a) {
            case A: {
                System.out.println("hello");
                break;
            }
            case B: {
                System.out.println("B");
                break;
            }
        }

        switch (a) {
            case A -> {
                System.out.println();
            }
            case B -> {
                System.out.println("sdflkj");
            }
        }
    }

    enum MyEnum {
        A,
        B,
        C
    }
}
