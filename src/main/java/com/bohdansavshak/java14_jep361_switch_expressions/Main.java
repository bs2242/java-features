package com.bohdansavshak.java14_jep361_switch_expressions;

public class Main {

	void main() {

		// -- default switch statement with fallthrough and break
		MyEnum m = MyEnum.C;
		switch (m) {
			case A:
				System.out.println("A");
				break;
			case B:
				System.out.println("B");
				break;
			default:
				System.out.println("default");
				break;
		}

		// switch expression
		var str = switch (m) {
			case A, B -> "A and B";
			case C -> "Only C";
		};
		System.out.println(str);

		// -- scope of variables in switch statement are shared. It means there is only
		// one
		// scope
		// of switch statement
		// and that's it.
		// with switch expression you have multiple scopes hence you can define same
		// variable
		// names inside each of them.
		switch (m) {
			case A:
			case B:
				String temp = "sdf"; // The scope of 'temp' continues to the }
				break;
			case C:
				String temp2 = "can't name it temp because temp is already in scope"; // Can't
																						// call
																						// this
				// variable
				// 'temp'
				break;
			default:
				String temp3 = "same as temp2"; // Can't call this variable 'temp'
		}

		/*
		 * very often switch expression is used as an expression anyway. you define
		 * variable and then in statement you assign value to that variable.
		 */

		/*
		 * switch expression but with block { then you need to yield result; }
		 *
		 *
		 * switch expression with case: { this is default fallthrough but in the end you
		 * need to yield result }
		 */

		var res = switch (m) {
			case A -> {
				System.out.println("A");
				yield "A";
			}
			case B -> {
				System.out.println("B");
				yield "B";
			}
			case C -> "C";
		};

		var res1 = switch (m) {
			case A: {
				System.out.println("A");
				yield "A";
			}
			case B: {
				System.out.println("B");
				yield "B";
			}
			case C:
				yield "C";
		};

		/*
		 * switch statement uses break; switch expression uses yield;
		 *
		 *
		 * Exhaustiveness
		 *
		 *
		 * break, return and continue, cannot jump through a switch expression Only yield
		 * at the end.
		 *
		 */

	}

	enum MyEnum {

		A, B, C

	}

}
