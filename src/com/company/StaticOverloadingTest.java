package com.company;

public class StaticOverloadingTest {

    public static void main(String args[]) {
        greet("John"); //will call static method with one String argument
        greet("John", "Good Morning"); //overloaded static method will be call

    }

    /*
     * static method which will be overloaded
     */
    public static void greet(String name){
        System.out.println("Hello " + name);
    }

    /*
     * Another static method which overload above Hello method
     * This shows that we can overload static method in Java
     */
    public static void greet(String name, String greeting){
        System.out.println(greeting + " " + name);
    }


}

