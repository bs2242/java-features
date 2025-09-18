package com.bohdansavshak.java16_jep395_records;

public class Ex3 {
    public static void main(String[] args) {
        record A(int i, int y) {
        }

        A a = new A(1, 1);
        System.out.println(a);
    }

    /*
     * Three constructors:
     *  - canonical implicitly you can override it if you want
     *  - compact (no section with parameters)
     *  - custom must call canonical with this(params);
     *
     */

    record B(int i, int y) {
        // canonical override
        public B(int i, int y) {
            this.i = i;
            this.y = y;
        }
    }

    record B1(int i, int y) {
        // compact
        public B1 {
            i += 1;
            y += 1;

            // here in the end there will be some implicit assignment of your parameters 'i' and 'y'
            // to private final fields of record 'this.i' and 'this.y'
            // you just modified parameters not fields above.
        }
    }

    record B2(int i, int y) {
        // custom
        public B2(B2 b2) {
            this(b2.i(), b2.y());
        }
    }

    /*
     * Can:
     *  - have static methods and fields
     *  - have other methods
     *  - override accessor methods and equals, hashCode and toString
     *  - implement interfaces
     *
     * Can't:
     *  - extend anything. Implicitly extends 'Record'. record is final by default.
     *  - define any instance fields.
     */


}
