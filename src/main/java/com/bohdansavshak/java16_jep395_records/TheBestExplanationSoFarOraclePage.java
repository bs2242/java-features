package com.bohdansavshak.java16_jep395_records;

public class TheBestExplanationSoFarOraclePage {

  public static void main(String[] args) {
    /*
          Immutable data carriers
          Record classes, which are a special kind of class, help to model plain data aggregates with less ceremony
          than normal classes.

          A record class declaration consists of a name; optional type parameters
          (generic record declarations are supported); a header, which lists the "components" of the record; and a body.


    A record class declares the following members automatically:
      1. For each component in the header, the following two members:
          A private final field with the same name and declared type as the record component. This field is sometimes
           referred to as a component field.
          A public accessor method with the same name and type of the component; in the Rectangle record class
          example, these methods are Rectangle::length() and Rectangle::width().
      2. A canonical constructor whose signature is the same as the header.
      3. equals and hashCode
      4. toString


              You can override public accessor methods including toString, hashCode and equals.
              You can declare instance methods in a record class.
              You can declare static fields, static initializers, and static methods in a record class, and they
              behave as they would in a normal

              You can also declare nested classes and interfaces in a record class,
              including nested record classes (which are implicitly static)

              You cannot declare instance variables (non-static fields) or instance initializers in a record class.
              You cannot declare native methods in a record class.

              Features of Record Classes:
              1. Records can be generic
              2. Records can implement interfaces
              3. Records are implicitly final. You can't extend from it. You can't declare it as abstract.
              4. You can annotate a record class and its individual components



              --
              Local Record Classes
              Like nested record classes, local record classes are implicitly static, which means that their own
              methods can't access any variables of the enclosing method, unlike local classes, which are never static.

              You can serialize and deserialize records, but you can't override some methods.

              inner class
              static inner class
              local inner class
              anonymous inner class

              when it comes to records and enums and interfaces they are always implicitly static.
              Look at MyExample

           */
  }

  record Rectangle(double length, double width) {}

  record RectangleWithCanonicalConstructor(double length, double width) {
    public RectangleWithCanonicalConstructor(double length, double width) {
      if (length <= 0 || width <= 0) {
        throw new java.lang.IllegalArgumentException(
            String.format("Invalid dimensions: %f, %f", length, width));
      }
      this.length = length;
      this.width = width;
    }
  }

  record RectangleWithCompactConstructor(double length, double width) {
    public RectangleWithCompactConstructor {
      if (length <= 0 || width <= 0) {
        throw new java.lang.IllegalArgumentException(
            String.format("Invalid dimensions: %f, %f", length, width));
        // it will assign length param to this.length implicitly the same for width.
      }
    }
  }

  record Pair<T extends Number>(T x, T y) {}

  record RectangleWithCustomConstructor(double length, double width) {
    // These constructors must invoke the record's canonical constructor.
    // Or other custom constructor but in the end it should be canonical constructor.
    public RectangleWithCustomConstructor(Pair<Double> corner) {
      this(corner.x().doubleValue(), corner.y().doubleValue());
    }
  }

  record RectangleWithStaticExample(double length, double width) {

    // Static field
    static double goldenRatio;

    // Static initializer
    static {
      goldenRatio = (1 + Math.sqrt(5)) / 2;
    }

    // Static method
    public static Rectangle createGoldenRectangle(double width) {
      return new Rectangle(width, width * goldenRatio);
    }
  }

  record RectangleWithNestedRecord(double length, double width) {

    // Public instance method
    public RectangleWithNestedRecord getRotatedRectangleBoundingBox(double angle) {
      RotationAngle ra = new RotationAngle(angle);
      double x = Math.abs(length * Math.cos(ra.angle())) + Math.abs(width * Math.sin(ra.angle()));
      double y = Math.abs(length * Math.sin(ra.angle())) + Math.abs(width * Math.cos(ra.angle()));
      return new RectangleWithNestedRecord(x, y);
    }

    // Nested record class
    record RotationAngle(double angle) {
      public RotationAngle {
        angle = Math.toRadians(angle);
      }
    }
  }
}
