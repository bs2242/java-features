package com.bohdansavshak.generics;

import java.util.List;

public class Introduction {

    public static void main(String[] args) {
        // Example of raw type. Raw types exists only because of backward compatibility
        BoxAsGenericType<Integer> boxOfInteger = new BoxAsGenericType<>();
        BoxAsGenericType baxRawType = new BoxAsGenericType();

        BoxAsGenericType newRawTypeInstance = boxOfInteger; // this is supported because.
        // What would happen if you try to run jdk 21 on java 4 codebase?.
        // Let's say you have Collections class which exists already in java 4 but since 5 there are
        // generics added.
        // So you code is written without generics in mind but internal implementation of
        // library now works with generics.
        // So in order to support exists code base this must exists. For example Collections.getList().
        // Imaginary method that was existing in java 4 bug since 5 it now returns generic List.
        // So if you have used this method it means that you expect just
        // List but since java 5 you would get parameterized type List<Something> which will break you
        // code
        // if this feature of assigning of parameterized type to raw type wouldn't be supported.

        BoxAsGenericType<Integer> boxOfInteger2 = new BoxAsGenericType<>();
        BoxAsGenericType rawTypeForBoxOfInteger = boxOfInteger2;
        rawTypeForBoxOfInteger.set(10);

        BoxAsGenericType<Integer> boxOfInteger3;
        boxOfInteger3 = getRawBox();
    }

    public static BoxAsGenericType getRawBox() {
        return new BoxAsGenericType();
    }

    public interface Pair<K, V> {
        K getKey();

        V getValue();
    }

    public interface B {
    }

    public interface C {
    }

    /*
    type parameter
    type argument
    generic type
    generic type invocation
    parameterized type
    Raw type ✔
    generic methods ✔
    Bounded type parameters(Multiple Bounds) ✔
    Generic Methods and Bounded type parameters ✔
    Generics, Inheritance and Subtypes ✔

    type inference
    Wildcards
    Type Erasure
    Restrictions on Generics


    Allows you to use type as parameter on class and interface definition and method definition.
     So you can reuse the same code multiple time but for different types.
    Generics allow types to be parameters when defining classes, interfaces and methods.

    Benefits of generics:
    - compile time checks
    - don't need to do any casting java does it for you
    - you can write generic code that can be reused multiple times

    naming conventions:
    E - for element
    K - for key
    T - for type
    V - for value
    N - for number
    S, U, V -- 2nd, 3rd, 4th types
    Only letter because otherwise it would be difficult to tell difference between type variable and class,
    interface name.


    Raw types
    Raw type is a generic class/interface that you define without any type arguments.
    Non-generic class or interface type is not a raw type.

    Generic methods - introduce their own type parameters.
    static and non-static is allowed as well as generic class constructors.
    Scope of type parameters in this case would be the scope of method.
    You should define list of type parameters in <> before return type of the method.

    Bounded type parameters
    If you want to restrict the types that can be used as type arguments then you use Bounded type parameters.
    Not only you limit which type can be used, but also you can call methods on bounded type in the scope of type param.
    Multiple Bounds
    <T extends B1 & B2 & B3>
    T is subtype of all three above.
    If one of the bounds a class it must be specified as first. In this case B1 must be a class of T extends from a
    class.


    Generics, Inheritance and Subtypes


     */
    public static class Util {
        public static <K, V> boolean compare(OrderedPair<K, V> p1, OrderedPair<K, V> p2) {
            return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
        }

        public static void main(String[] args) {
            OrderedPair<Integer, String> p1 = new OrderedPair<>(10, "str");
            OrderedPair<Integer, String> p2 = new OrderedPair<>(20, "str");

            boolean isSame = Util.compare(p1, p2); // Explicit was of telling java which type arguments
            // use for static generic method.
            boolean isSame2 = Util.compare(p1, p2); // type inference java implicitly define types
        }
    }

    public static class Box {
        private Object obj;

        public void set(Object obj) {
            this.obj = obj;
        }

        public Object get() {
            return obj;
        }
    }

    public static class BoxAsGenericType<
            T> { // <T> in this case is called type parameter or type variable.
        // Type variable can be any non-primitive type you specify.
        private T t;

        public void set(T obj) {
            this.t = obj;
        }

        public T get() {
            return t;
        }
    }

    public static class OrderedPair<K, V> implements Pair<K, V> {
        private final K key;
        private final V value;

        public OrderedPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public static void main(String[] args) {
            OrderedPair<String, BoxAsGenericType<Integer>> p =
                    new OrderedPair<>("hello", new BoxAsGenericType<Integer>()); // parameterized type
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static class BoundedTypeParamExample<T> {
        private T t;

        public static void main(String[] args) {
            BoundedTypeParamExample<Integer> boundedTypeOfInteger = new BoundedTypeParamExample<>();
            boundedTypeOfInteger.set(Integer.valueOf(10));
            //            boundedTypeOfInteger.inspect("Str"); // this throws compile time error because
            // inspect can only
            //            accept Number like arguments
            boundedTypeOfInteger.inspect(Double.valueOf(10.1));
        }

        public T get() {
            return t;
        }

        public void set(T t) {
            this.t = t;
        }

        public <U extends Number> void inspect(U u) {
            System.out.println("u = " + u.getClass().getName());
            System.out.println("t = " + t.getClass().getName());
        }
    }

    public static class NaturalNumber<T extends Integer> {
        private final T n;

        public NaturalNumber(T t) {
            this.n = t;
        }

        public static void main(String[] args) {
            NaturalNumber<Integer> naturalNumberOfInteger10 = new NaturalNumber<>(10);
            System.out.println("naturalNumberOfInteger10 isEven = " + naturalNumberOfInteger10.isEven());
        }

        public boolean isEven() {
            return n.intValue() % 2 == 0;
        }
    }

    public static class A {
    }

    public static class MultipleBoundTypeParameter<T extends A & B & C> {
    }

    //    public static class MultipleBoundTypeParameter1<T extends B & A & C> {}

    public static class MethodExample {
        //        public <T> int countGreaterThan1(T[] arr, T elem) {
        //            int count = 0;
        //            for (T e : arr) {
        //                if (e > elem) {
        //                    ++count;
        //                }
        //            }
        //            return count;
        //        }

        public <T extends Comparable<T>> int countGreaterThan(T[] arr, T elem) {
            int count = 0;
            for (T e : arr) {
                if (e.compareTo(elem) > 0) {
                    ++count;
                }
            }
            return count;
        }
    }

    public static class GenericHierarchy {
        public static void main(String[] args) {
            BoxAsGenericType<Number> numberBoxAsGenericType = new BoxAsGenericType<>();
            numberBoxAsGenericType.set(Integer.valueOf(10));
            // Integer extends Number. So in every place where Number is expected you can pass Integer.

            // But when BoxAsGenericType<Number> is expected you can't pass BoxAsGenericType<Integer>
            // because both have superclass Object and there is no direct link between them.
            // also because List<E> extends from Collection<E> it means when Collection<E> is expected you
            // can pass in List<E>

        }

        // example of my own generic type that extends from another generic type.
        // so technically by doing generic type invocation like ListWithPayLoad<String, Integer> it
        // extends from List<String>.
        // Also ListWithPayload<String, String> also extends from List<String>
        // Also ListWithPayload<String, Number> also extends from List<String>
        // But not ListWithPayload<Integer, String>. Because it would be extending from List<Integer>
        public interface ListWithPayload<E, P> extends List<E> {
            void setPayload(int index, P val);
        }
    }
}
