package com.company;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;

public class Sorting {

    public static void main(String...args){

        // 1
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red")));

        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(30, "green"));
        
        // 2
        // [Apple{color='green', weight=30}, Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight()); 
        }});
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(20, "red"));
        
        // 3
        // [Apple{color='red', weight=20}, Apple{color='green', weight=30}, Apple{color='green', weight=155}]
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);
        
        // reshuffling things a little
        inventory.set(1, new Apple(10, "red"));
        
        // 4
        // [Apple{color='red', weight=10}, Apple{color='red', weight=20}, Apple{color='green', weight=155}]
        inventory.sort(comparing(Apple::getWeight)
                 .reversed()
                 .thenComparing(Apple::getColor));
        System.out.println(inventory);

        List<String> str = Arrays.asList("a", "b", "A", "B");
        //str.sort((s1, s2) -> s1.compareTo(s2));
        str.sort(String::compareToIgnoreCase);

        /*for (String s : str) {
            System.out.println("s ->" + s);
        }*/

        Supplier<Apple> c = Apple::new;
        Apple a1 = c.get();

        Function<Integer, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(100);

        BiFunction<Integer, String, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(100, "green");

        Predicate<Apple> redApple = a -> a.getColor().equals("red");
        Predicate<Apple> notRedApple = redApple.negate();

    }

    public static class Apple {
        private Integer weight = 0;
        private String color = "";

        public Apple() {

        }

        public Apple(Integer weight){
            this.weight = weight;
        }

        public Apple(Integer weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                   "color='" + color + '\'' +
                   ", weight=" + weight +
                   '}';
        }
    }

    static class AppleComparator implements Comparator<Apple> {
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }
}
