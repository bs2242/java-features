package com.bohdansavshak.java16_jep_394_pattern_matching_for_instance_of;

public class Exercise1 {

    public static void main(String[] args) {
        String str = "my string";
        Object obj = str;
        if (obj instanceof String s) {
            System.out.println(s);
        }

        /*
        Pattern matching consists of three things.
        Predicate
        Target
        Pattern variable

        we take target and do the test with predicate if it matches to our structure then we assign target to our
        pattern variable
        Simple as that.
         */
    }
}
