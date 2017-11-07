package com.company;

import java.util.Stack;

public class StackAndQueueTest {

    public static void main(String... args){
        StackWithMin2 stack = new StackWithMin2();
        stack.push(3);
        stack.push(1);
        stack.push(12);
        stack.push(8);

        //System.out.println("min value = " + stack.min());

        sort(stack);

        stack.push(5);
        sort(stack);
    }

    public static void sort(Stack s) {
        Stack r = new Stack();
        while (!s.isEmpty()) {
            int tmp = (int)s.pop();
            while (!r.isEmpty() && (int)r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }

        while (!r.isEmpty()) {
            s.push(r.pop());
        }

        System.out.println("Sort Stack => " + s.toString());
    }
}
