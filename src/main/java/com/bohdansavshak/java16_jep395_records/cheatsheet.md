Records are: 
- modeling data as data
- records are classes that act as transparent carriers for immutable data
- record is a special class whose purpose is just to aggregate values and be transparent.

terminology to remember: 
record components. (int x, int y) 
record A(int x, int y) {}


Three constructors:
*  - canonical implicitly you can override it if you want
*  - compact (no section with parameters)
*  - custom must call canonical with this(params);



* Can:
*  - have static methods and fields
*  - have other methods
*  - override accessor methods and equals, hashCode and toString
*  - implement interfaces
*
* Can't:
*  - extend anything. Implicitly extends 'Record'. record is final by default.
*  - define any instance fields.


In this JEP there were some changes to how you can define static inner classes in other inner classes or methods. 
You need to remember this -> 
whenever you define 'interface', 'enum', 'record' in another class it is implicitly static
whenever you define 'class' in another class it is implicitly non-static. You have option to make it static.

    class B {
        enum C4 {
    
        } // this is implicitly static.
        interface C3 {
    
        } // this is implicitly static
    
        record C1() {
        } // this is implicitly static
    
        class C2 {
    
        } // this is implicitly non-static
    }