package com.bohdansavshak.java16_jep395_records;

public class Main {

  /*

      Record classes, which are a special kind of class, help to model plain data aggregates with less ceremony than
      normal classes.

      canonical, compact and custom constructors.
      private final immutable fields.
      equals, hashCode and toString out of the box.
      Generics are allowed.
      Static fields and methods are allowed.
      You can create your own methods inside record.
      You can implement interfaces as well.

      record is a specific type of class that act as transparent carriers for immutable data.
      Writing Java code that models a handful of values should be easier to write, to read, and to verify as correct.
      Record is about modeling data as data not as mutable classes with behaviour.
      Record is special kind of class in java.

      Record is only about state. By defining state you define automatically its api.



      When you define new record it automatically gets canonical constructor.
      record Point(int x, int y) {}
      is translated to this
      record Point() {
          // Implicitly declared fields
          private final int x;
          private final int y;

          // Other implicit declarations elided ...

          // Implicitly declared canonical constructor
          Point(int x, int y) {
              this.x = x;
              this.y = y;
          }
      }
      You can explicitly declare canonical constructor.
      Record header is int x and int y in this case.

      example of compact constructor
      record Range(int lo, int hi) {
          Range {
              if (lo > hi)  // referring here to the implicit constructor parameters
                  throw new IllegalArgumentException(String.format("(%d,%d)", lo, hi));
          }
      }
      Parameters for compact constructor are defined implicitly and assignment to corresponding fields are also
      implicit at the end of compact constructor.
      Example
      Here is a compact canonical constructor that normalizes its formal parameters:

  record Rational(int num, int denom) {
      Rational {
          int gcd = gcd(num, denom);
          num /= gcd;
          denom /= gcd;
      }
  }

  This declaration is equivalent to the conventional constructor form:

  record Rational(int num, int denom) {
      Rational(int num, int demon) {
          // Normalization
          int gcd = gcd(num, denom);
          num /= gcd;
          denom /= gcd;
          // Initialization
          this.num = num;
          this.denom = denom;
      }
  }


  Rules:
   Record implicitly extends Record class. It doesn't allow any extends clause. Even extends Record.
   Record class is implicitly final and can't be abstract. State => API. We don't want any subclass to change our api
    because then State => API wouldn't work.
   Record headers define record fields and they are implicitly final. Because record is immutable data carrier.
   Record can't have other instance fields except those that are defined in record headers. And cannot contain
   instance initializers.
   When you define explicitly accessor methods they should match exactly type of field
    record R(int i) {
          public int i() {
              return this.i;
          }
      }
   You can't declare native methods in record
   What is allowed:
   Record can be generic, nested or created in their own file
   Static is allowed, static fields, methods and initializers
   You can create new instance methods.
   You can implement interface
   record can declare nested types, including nested record classes. Record if nested is implicitly static. This was
   done to not add any state behind the scenes for nested record
   you can declare annotation on records. They will be propagated to field, accessors, constructors
   serialization, deserialization but there are some restrictions on which methods can be used.

   local record classes are implicitly static.
   is a particular case of nested record classes.

   local classes are always not static. You can't define them as static. So local class that is defined in the method
    can always access enclosing method variables and instance fields of enclosing class.
  Local enum classes and local interfaces are always implicitly static.
  Also nested enum and interfaces are always implicitly static.
  inner classes now allows static nested classes.







       */

    public static void main(String[] args) {
        Point<Double> doublePoint = new Point<>(1.0, 2.0);
        doublePoint.privateHello(); // why this is allowed?
        doublePoint.publicHello();
    }

    record Point<T>(T t1, T t2) {
        private void privateHello() {
            System.out.println(t1.toString() + t2.toString());
        }

        public void publicHello() {
            privateHello();
        }
    }

    record Box(int i1, int i2) {
        Box(int i1, int i2) {
            this.i1 = i1;
            this.i2 = i2;
        }
    }

    class A {
        public static int i = 20;

        public static void hello() {
        }

        enum MyEnum {
            ONE,
            TWO
        } // implicitly static

        // interfaces.

        interface I {
        } // implicitly static

        record B() {
        } // now inner classes allows static nested classes including record enum and

        static class C {
        }
    }
}
