package com.bohdansavshak.java21_jep441_pattern_matching_for_switch;

public class Main {
  public static void main(String[] args) {
    /*
    before java 21
    switch works only on char, byte, short and int(autoboxed versions too) + enum and string
    work on constants only.

     */
  }

  static String formattedPatternSwitch(Object obj) {
    return switch (obj) {
      case Integer i -> String.format("int %d", i);
      case Long l -> String.format("long %d", l);
      case Double d -> String.format("double %f", d);
      case String s -> String.format("String %s", s);
      default -> obj.toString();
    };
  }

  /*
  Switches and null
  before java 21 if you pass null to switch you will get NullPointerException.
  But know you can create another case label specifically for null check.

  if there would be no case null in switch then you would get NullPointerException
  if case null is there then right block to it will be executed.
  default doesn't mean it matches null just to maintain backward compatibility.
  */

  static void testFooBarNew(String s) {
    switch (s) {
      case null -> System.out.println("Oops");
      case "Foo", "Bar" -> System.out.println("Great");
      default -> System.out.println("Ok");
    }
  }

  /*
  guarded case label
   */

  static void testStringNew(String response) {
    switch (response) {
      case null -> {}
      case String s when s.equalsIgnoreCase("YES") -> System.out.println("You got it");
      case String s when s.equalsIgnoreCase("NO") -> System.out.println("Shame");
      case String s -> System.out.println("Sorry?");
    }
  }

  static void testStringEnhanced(String response) {
    switch (response) {
      case null -> {}
      case "y", "Y" -> System.out.println("You got it");
      case "n", "N" -> System.out.println("Shame");
      case String s when s.equalsIgnoreCase("YES") -> System.out.println("You got it");
      case String s when s.equalsIgnoreCase("NO") -> System.out.println("Shame");
      case String s -> System.out.println("Sorry?");
    }
  }

  /*
  Switches and enum constants

  before java 21
  enum must be a variable that is passed to switch and switch case must contain only enum names.
   */

  static void exhaustiveSwitchWithoutEnumSupport(CardClassification c) {
    switch (c) {
      case Suit s when s == Suit.CLUBS -> System.out.println("It's clubs");
      case Suit s when s == Suit.DIAMONDS -> System.out.println("It's diamonds");
      case Suit s when s == Suit.HEARTS -> System.out.println("It's hearts");
      case Suit s -> System.out.println("It's spades");
      case Tarot t -> System.out.println("It's a tarot");
    }
  }

  static void exhaustiveSwitchWithBetterEnumSupport(CardClassification c) {
    switch (c) {
      case Suit.CLUBS -> System.out.println("It's clubs");
      case Suit.DIAMONDS -> System.out.println("It's diamonds");
      case Suit.HEARTS -> System.out.println("It's hearts");
      case Suit.SPADES -> System.out.println("It's spades");
      case Tarot t -> System.out.println("It's a tarot");
    }
  }

  static void goodEnumSwitch1(Currency c) {
    switch (c) {
      case Coin.HEADS -> { // Qualified name of enum constant as a label
        System.out.println("Heads");
      }
      case Coin.TAILS -> {
        System.out.println("Tails");
      }
    }
  }

  static void goodEnumSwitch2(Coin c) {
    switch (c) {
      case HEADS -> {
        System.out.println("Heads");
      }
      case Coin.TAILS -> { // Unnecessary qualification but allowed
        System.out.println("Tails");
      }
    }
  }

  static void badEnumSwitch(Currency c) {
    switch (c) {
      case Coin.HEADS -> {
        System.out.println("Heads");
      }
      //            case TAILS -> {         // Error - TAILS must be qualified
      //                System.out.println("Tails");
      //            }
      default -> {
        System.out.println("Some currency");
      }
    }
  }

  static void typeTester(Object obj) {
    switch (obj) {
      case null -> System.out.println("null");
      case String s -> System.out.println("String");
      case Color c -> System.out.println("Color: " + c);
      case Point p -> System.out.println("Record class: " + p);
      case int[] ia -> System.out.println("Array of ints of length" + ia.length);
      default -> System.out.println("Something else");
    }
  }

  static void first(Object obj) {
    switch (obj) {
      case String s -> System.out.println("A string: " + s);
      case CharSequence cs -> System.out.println("A sequence of length " + cs.length());
      default -> {
        break;
      }
    }
  }

  static void error(Object obj) {
    switch (obj) {
      case CharSequence cs -> System.out.println("A sequence of length " + cs.length());
      //            case String s ->    // Error - pattern is dominated by previous pattern
      //                    System.out.println("A string: " + s);
      default -> {
        break;
      }
    }
  }

  static void dominationRuleOfThumbs() {
    Integer i = Integer.valueOf(1);
    switch (i) {
      case -1, 1 -> System.out.println(1); // Special cases
      case Integer j when j > 0 -> System.out.println(2); // Positive integer cases
      case Integer j -> System.out.println(3); // All the remaining integers
    }
  }

  static void exhaustivnessWithEnum() {
    Color1 color = Color1.YELLOW;
    //        int numLetters = switch (color) {   // Error - not exhaustive!
    //            case Color1.RED -> 3;
    //            case Color1.GREEN -> 5;
    //        };
    int numLetters = switch (color) { // Exhaustive!
          case RED -> 3;
          case GREEN -> 5;
          case YELLOW -> 6;
        };

    /*
    If we omit the default clause then we will discover at compile time if we have forgotten a case label,
    rather than finding out at run time — and maybe not even then.
    In conclusion: An exhaustive switch without a match-all clause is better than an exhaustive switch with one, when
     possible.
     */

  }

  /*
  Patterns in switch labels

  SwitchLabel:
      case CaseConstant { , CaseConstant }
      case null [, default]
      case Pattern [ Guard ]
      default
   */

  static int testSealedExhaustive(S s) {
    return switch (s) {
      case A a -> 1;
      case B b -> 2;
      case C c -> 3;
    };
  }

  /*
  Scope of pattern variable declarations

   */
  static void testScope1(Object obj) {
    switch (obj) {
      case Character c
      when c.charValue() == 7:
        System.out.println("Ding!");
        break;
      default:
        break;
    }
  }

  static void testScope2(Object obj) {
    switch (obj) {
      case Character c -> {
        if (c.charValue() == 7) {
          System.out.println("Ding!");
        }
        System.out.println("Character");
      }
      case Integer i ->
          throw new IllegalStateException("Invalid Integer argument: " + i.intValue());
      default -> {
        break;
      }
    }
  }

  /*
  Dominance of case labels
   */

  static void testScope3(Object obj) {
    switch (obj) {
      case Character c:
        if (c.charValue() == 7) {
          System.out.print("Ding ");
        }
        if (c.charValue() == 9) {
          System.out.print("Tab ");
        }
        System.out.println("Character");
      default:
        System.out.println();
    }
  }

  static void testScopeError(Object obj) {
    switch (obj) {
      case Character c:
        if (c.charValue() == 7) {
          System.out.print("Ding ");
        }
        if (c.charValue() == 9) {
          System.out.print("Tab ");
        }
        System.out.println("character");
      //            case Integer i:                 // Compile-time error
      //                System.out.println("An integer " + i);
      default:
        break;
    }
  }

  /*
  A guarded pattern case label dominates another pattern case label (guarded or unguarded)
  only when both the former's pattern dominates the latter's pattern and when its guard is a constant expression of
  value true.
   For example, the guarded pattern case label case String s when true dominates the pattern case label case String s.
    We do not analyze the guarding expression any further in order to determine more precisely
     which values match the pattern label — a problem which is undecidable in general.
   */

  static void nullMatch(Object obj) {
    switch (obj) {
      case null -> System.out.println("null!");
      case String s -> System.out.println("String");
      default -> System.out.println("Something else");
    }
  }

  //    static void matchAll(String s) {
  //        switch(s) {
  //            case String t:
  //                System.out.println(t);
  //                break;
  //            default:
  //                System.out.println("Something else");  // Error - dominated!
  //        }
  //    }

  //    static void matchAll2(String s) {
  //        switch(s) {
  //            case Object o:
  //                System.out.println("An Object");
  //                break;
  //            default:
  //                System.out.println("Something else");  // Error - dominated!
  //        }
  //    }

  /*
  Exhaustiveness of switch expressions and statements
   */

  static void nullMatch2(Object obj) { // throws NullPointerException if obj is null
    switch (obj) {
      case String s -> System.out.println("String: " + s);
      case Integer i -> System.out.println("Integer");
      default -> System.out.println("default");
    }
  }

  // is equivalent to
  static void nullMatch21(Object obj) {
    switch (obj) {
      case null -> throw new NullPointerException();
      case String s -> System.out.println("String: " + s);
      case Integer i -> System.out.println("Integer");
      default -> System.out.println("default");
    }
  }

  /*
  Exhaustiveness and sealed classes
   */

  static void exampleAnR(R r) {
    switch (r) {
      case R(var i):
        System.out.println(i);
    }
  }

  // As of Java 21
  static void example(Object obj) {
    switch (obj) {
      case R r
      when (r.i / 0 == 1):
        System.out.println("It's an R!");
      default:
        break;
    }
  }

  void testScope4(Object obj) {
    switch (obj) {
      case String s:
        System.out.println("A string: " + s); // s in scope here!
      default:
        System.out.println("Done"); // s not in scope here
    }
  }

  public enum Suit implements CardClassification {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES
  }

  enum Coin implements Currency {
    HEADS,
    TAILS
  }

  enum Color {
    RED,
    GREEN,
    BLUE
  }

  /*
  Exhaustiveness and compatibility

  The requirement of exhaustiveness applies to both pattern switch expressions and pattern switch statements.
  To ensure backward compatibility, all existing switch statements will compile unchanged.
  But if a switch statement uses any of the switch enhancements described in this JEP
  then the compiler will check that it is exhaustive.

  More precisely, exhaustiveness is required of any switch statement that uses pattern or null labels or
  whose selector expression is not one of the legacy types
  (char, byte, short, int, Character, Byte, Short, Integer, String, or an enum type)
   */

  enum Color1 {
    RED,
    YELLOW,
    GREEN
  }

  sealed interface CardClassification permits Suit, Tarot {}

  sealed interface Currency permits Coin {}

  sealed interface S permits A, B, C {}

  record Point(int i, int j) {}

  record C(int i) implements S {} // Implicitly final

  /*
  Dealing with null
   */

  record R(int i) {
    public int i() { // bad (but legal) accessor method for i
      return i / 0;
    }
  }

  final class Tarot implements CardClassification {}

  final class A implements S {}

  /*
  Errors
   */

  final class B implements S {}

  class AnotherExample {
    static int testGenericSealedExhaustive(I<Integer> i) {
      return switch (i) {
        // Exhaustive as no A case possible!
        case B<Integer> bi -> 42;
      };
    }

    sealed interface I<T> permits A, B {}

    final class A<X> implements I<String> {}

    final class B<Y> implements I<Y> {}
    /*
    Again, the notion of exhaustiveness is an approximation
    Because of separate compilation, it is possible for a novel implementation of the interface
    I to show up at runtime, so the compiler will in this case insert a synthetic default clause that throws.
     */
  }

  // The invocation exampleAnR(new R(42)) causes a MatchException to be thrown

  class A1 {
    static void switchStatementExhaustive(S s) {
      switch (s) { // Error - not exhaustive;
        // missing clause for permitted class B!
        case B b:
          {
            System.out.println("B");
            break;
          }
        case A a:
          System.out.println("A");
          break;
        case C c:
          System.out.println("C");
          break;
      }
    }

    sealed interface S permits A, B, C {}

    record C(int i) implements S {} // Implicitly final

    final class A implements S {}

    final class B implements S {}
  }
  //    The invocation example(new R(42)) causes an ArithmeticException to be thrown.
}
