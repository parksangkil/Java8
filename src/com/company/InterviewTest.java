package com.company;

public class InterviewTest {
    public static void main(String... args) {
        // Write a java program to reverse a string?
        StringBuffer sbf = new StringBuffer("MyJava");
        System.out.println(sbf.reverse());

        String str = "MyJava";
        char[] strArray = str.toCharArray();
        for (int i = strArray.length - 1; i >= 0; i--)
        {
            System.out.print(strArray[i]);     //Output : avaJyM
        }
        //Write a java program to reverse a string?

    }
}
