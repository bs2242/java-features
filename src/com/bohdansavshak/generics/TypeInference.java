package com.bohdansavshak.generics;

public class TypeInference {

    /*
    Type Inference - is a thing in java which make conclusion which type argument to be used based on arguments that you pass to your methods.
    if you have generic method that accepts U and List<U> then just by adding Integer.valueOf(10) as first argument java
    already knows that type in this case would be Integer and you don't need to specify type explicitly when calling a method.
    like this. UtilSampleClass.<Integer>genericStaticMethod(Integer.valueOf(10))
    Explicitly define type in generic method is also called 'type witness'

    this one is not very interesting.
    Only type witness. And java 7 diamond operators.
    Java is smart to infer type if it can.




     */

    public static void main(String[] args) {

    }
}
