package com.bohdansavshak.java16_jep395_records;

public class Ex1 {
  public static void main(String[] args) {
    /*
    Records - transparent carriers for immutable data
    Or special kind of class that helps you model plain data aggregates with less ceremony


     */
    record A(int i) {
      /*
      you have here state -> api
      also hashCode, equals, toString
      and canonical constructor.

      you can override canonical constructor
      you can define compact constructor
      you can define custom constructor

      you can have static fields and static methods and static initializers
      you can have generics
      you can implement interfaces and define new methods

      you can't have new instance variables or instance initialization blocks.
      You can't declare native methods in a record class.

      Records are implicitly final. You can't extend from anything even from Record class from which all records extend implicitly.
      Annotations are allowed

      There is some limitation in deserialization
      records are always implicitly static.

      they relaxed constraint on having static members on inner classes.
      You can have records in methods
      or in other classes or in interfaces or even in enums. Or even in inner classes.

       */

    }
  }
}
