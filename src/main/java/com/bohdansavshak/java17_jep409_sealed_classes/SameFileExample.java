package com.bohdansavshak.java17_jep409_sealed_classes;

public sealed class SameFileExample
// The permits clause has been omitted
// as its permitted classes have been
// defined in the same file.
{
}

final class Circle extends SameFileExample {
    float radius;
}

non-sealed class Square extends SameFileExample {
    float side;
}

sealed class Rectangle extends SameFileExample {
    float length, width;
}

final class FilledRectangle extends Rectangle {
    int red, green, blue;
}
