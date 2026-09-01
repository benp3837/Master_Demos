package com.fnma;

public class Main {

    public static void main(String[] args) {

        //Since int1 and int2 in ScopeTester are STATIC, we can call them directly from the class
        System.out.println(ScopeTester.int1); //7
        System.out.println(ScopeTester.int2); //0

        //Statics are all over built-in Java classes
        System.out.println(Math.PI); //Useful! I don't have to instantiate a Math object for this

        //Another use case of static:
        //The value of static fields will change for EVERY object if it changes in one

        ScopeTester st = new ScopeTester();
        ScopeTester st2 = new ScopeTester();

        System.out.println(st.int1); //7
        System.out.println(st2.int1); //7
        System.out.println("***changing int1 to 500***");
        st.int1 = 500;
        System.out.println(st.int1); //500
        System.out.println(st2.int1); //500

        //Using the nonstatic variable
        //System.out.println(ScopeTester.int3); <- CAN'T access nonstatics through the class. Must instantiate!

        System.out.println(st.int3); //NOW we can access it, since we're going through the object

        //If we change the value of a nonstatic, it does NOT CHANGE for other objects
        st.int3 = 8000;
        System.out.println(st.int3); //8000
        System.out.println(st2.int3); //5


        //Static methods can be called within static methods (main is static)
        ScopeTester.staticMethod();

        //Same can't be said for nonstatic methods
        //ScopeTester.nonstaticMethod(); <- NO!

        //UNLESS you go through the object
        st.nonstaticMethod();


        //System.out.println(methodScopedVar);

    }

    //A method to demo method scope and block scope
    public static void scopesExampleMethod(int x){

        //this variable is METHOD SCOPED. Only visible within this method
        int methodScopedVar = 5;

        //System.out.println(blockScopedVar);

        if(true){

            //this variable is BLOCK SCOPED. Only visible within this block
            int blockScopedVar = 5;

        }

    }

}
