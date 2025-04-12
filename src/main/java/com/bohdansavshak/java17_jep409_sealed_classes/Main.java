package com.bohdansavshak.java17_jep409_sealed_classes;

public class Main {

	/*
	 * It's about closed hierarchy You define who can extend your class/interface. By
	 * doing it you have one more modeling technique. It shines when used with pattern
	 * matching.
	 *
	 * Java supports data oriented programming records sealed classes pattern matching
	 *
	 * data and nothing but data.
	 *
	 *
	 */

	public sealed class Shape permits Circle, Square, Rectangle {

	}

	public final class Circle extends Shape {

	}

	public non-sealed class Square extends Shape {

	}

	public sealed class Rectangle extends Shape permits FilledRectangle {

	}

	public final class FilledRectangle extends Rectangle {

	}

	/*
	 * constrains - They must be accessible by the sealed class at compile time. - They
	 * must directly extend the sealed class. - They must have exactly one of the
	 * following modifiers to describe how it continues the sealing initiated by its
	 * superclass: final: Cannot be extended further sealed: Can only be extended by its
	 * permitted subclasses non-sealed: Can be extended by unknown subclasses; a sealed
	 * class cannot prevent its permitted subclasses from doing this -They must be in the
	 * same module as the sealed class (if the sealed class is in a named module) or in
	 * the same package (if the sealed class is in the unnamed module, as in the
	 * Shape.java example).
	 *
	 */

	/*
	 * you can have also sealed interfaces. If you specify record class in permits clause.
	 * Don't forget that records are implicitly final.
	 *
	 */

}
