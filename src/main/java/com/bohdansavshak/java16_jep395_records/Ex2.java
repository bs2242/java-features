package com.bohdansavshak.java16_jep395_records;

public class Ex2 {

	record A(int i) {
	} // hashCode, equals, toString and canonical constructor plus i() method

	record B(int i) {
		public B(int i) { // override canonical constructor
			this.i = i;
		}
	}

	record C(int i) {
		public C { // compact constructor
			i = +i;
		}

		public C(A a) { // custom constructor
			this(10);
		}
	}

	// all above is kind of core thing you need to know about records.

	// generics, interfaces, statics are allowed
	// new instance fields and initializers are not allowed
	// you can't extend record because it's implicitly final
	// native methods are not allowed
	// some trick with serialization
	// relaxed constrained on static inner classes in inner classes

	/*
	 * everything is static when you declare it in another class. except class it's
	 * implicitly non-static
	 */

}
