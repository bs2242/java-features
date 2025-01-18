package com.bohdansavshak.bobocode.memory;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorCode {

  private static final List<String> myList = new ArrayList<>();

  public static void main(String[] args) {
    while (true) {
      myList.add("String");
    }
  }
}
