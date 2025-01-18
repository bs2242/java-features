package com.bohdansavshak.java16_jep395_records;

public class Training {

  // constructors
  // toString, hashCode, equals
  // plus access method for my record component 'i'

  record A(int i) {}

  record A1(int i) {
    A1(int i) {
      this.i = i;
    }
  }

  record A2(int i) {
    A2 {}
  }

  record A3(int i) {
    A3(A3 a3) {
      this(a3.i());
    }
  }
}
