package com.fnma;

//This Class will have a bunch of variables and some methods I'll use to demonstrate class vs instance scope
//static (class scoped) vs nonstatic (instance scoped) variables
public class ScopeTester {

    //This is a Class scoped variable. It's Class scoped due to the "static" non-access modifier
    //We initialized it with a value of 7
    public static int int1 = 7;

    //Here's another Class scoped variable. It's uninitialized
    public static int int2;

    //This is an INSTANCE Scoped variable. It's nonstatic. Note the lack of the "static" non-access modifier
    public int int3 = 5;

    public static void staticMethod(){
        System.out.println("Hello from the static method in ScopeTester");
    }

    public void nonstaticMethod(){
        System.out.println("Hello from the nonstatic method in ScopeTester");
    }


}
