package com.bohdansavshak.methodReference;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class MethodReference {

    public MethodReference() {}

    public MethodReference(String name) {}

    public static void main(String[] args) {
        /*
        1. Static method reference
        2. Instance method reference of an arbitrary object of a particular type (Unbound method reference)
        3. Instance method reference of a particular object (Bound method reference)
        4. Constructor method reference
         */

        // 1. Static method reference example
        Stream.of("e1", "e2").forEach(MethodReference::staticMethod); // e -> MethodReference.staticMethod(e)

        // 2. Instance method reference of an arbitrary object of a particular type
        List<String> sortedElements = Stream.of("e1", "e2")
                .sorted(String::compareTo) // (e1, e2) -> e1.compareTo(e2)
                .toList();

        // 3. Instance method reference of a particular object
        Stream.of("e1", "e2").forEach(System.out::println); // e -> System.out.println(e)

        var methodReferenceObj = new MethodReference();
        Stream.of("e1", "e2").forEach(methodReferenceObj::instanceMethod); // e -> methodReferenceObj.instanceMethod(e)

        // 4. Reference to constructor
        Function<String, MethodReference> function = MethodReference::new; // e -> new MethodReference(e);
    }

    public static void staticMethod(String str) {
        System.out.println(str);
    }

    public void instanceMethod(String str) {
        System.out.println(str);
    }
}
