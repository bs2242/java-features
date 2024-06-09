package com.bohdansavshak.java14_jep361_switch_expressions;

public class Ex1 {
    enum MyEnum {
        A, B, C
    }

    void main() {
        var a = MyEnum.A;

        var result = switch (a) {
            case A -> "A";
            case B, C -> "B and C";
        };

        // each case have its own scope so you can define multiple variables temp.
        var result1 = switch (a) {
            case A -> {
                var temp = "temp";
                yield "A";
            }
            case B, C -> {
                var temp = "temp";
                yield "B and C";
            }
        };
    }
}
