package com.bohdansavshak.java16_jep_394_pattern_matching_for_instance_of;

public class Ex2 {

    public static void main(String[] args) {
        Object obj = "Hello";
        if (obj instanceof String patternVariable) {
            System.out.println(patternVariable);
        }
    }
}
