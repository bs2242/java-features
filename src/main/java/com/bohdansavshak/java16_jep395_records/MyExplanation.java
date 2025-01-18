package com.bohdansavshak.java16_jep395_records;

public class MyExplanation {

    // static nested classes in scope of records jep 395
  /*


  just class:
     nested inner class
     static inner class
     local inner class
     anonymous inner class

    for interface, record and enum they are always implicitly static. And can't be defined non-static.
    also in nested inner class you can define static inner classes + records + enums + interfaces


    nested inner class
    local inner class
    static inner class
    anonymous inner class


    Before this jep
    You weren't able to define static member in inner class.
    They relaxed this constraint to allow records to be defined in inner classes.
    But now you can also define static classes in inner classes. and interfaces and enums.



      */

    record A() {
    }

    static class B {
        public void v() {
            enum C4 {} // this is implicitly static.
            interface C3 {
            } // this is implicitly static

            record C1() {
            } // this is implicitly static

            class C2 {
            } // this is implicitly non-static
        }

        enum E {} // this is implicitly static

        interface I {
        } // this is implicitly static

        record C(int i) {
        } // this is implicitly static

        static class B1 {
        } // can be static or can be non-static. But implicitly it's non-static
    }
}
