package com.company;

import java.util.*;

public class MapExam {
    //Key와 Value형태로 넣는 HashMap선언
    TreeMap<Integer, String> map = new TreeMap<>();

    public void addMap()
    {
        //임의의 값을 해쉬맵에 추가
        map.put(22, "서울");
        map.put(44, "부산");
        map.put(66, "대구");
        map.put(55, "광주");
        map.put(11, "전주");
    }

    public void printMap()
    {
        //해쉬맵의 키 테이블을 가져오기
        Set<Integer> set = map.keySet();

        //해쉬맵의 값을 출력
        for(Integer i : set)
            System.out.println(i + "번의 값 : " + map.get(i));

    }

    public static void main(String[] args)
    {
        MapExam mapExam = new MapExam();

        mapExam.addMap();
        mapExam.printMap();

        /*Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread Start");
            }
        };*/
        Thread thread = new Thread( () -> System.out.println("Thread Start") );

        thread.start();

        List<Integer> items = new ArrayList<Integer>();
        items.add(1);
        items.add(2);
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(3);
        System.out.println(items); // [1, 2, 1, 2, 3, 3]

        List<Integer> uniqueItems = new ArrayList(new HashSet(items));
        System.out.println(uniqueItems); // [1, 2, 3]

        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        Set<Thread> threads = map.keySet();
        for(Thread thread1 : threads){
            System.out.println("Name : " + thread1.getName() + ((thread1.isDaemon()) ? "데몬" : "주"));
            System.out.println("스레드 그룹 : " + thread1.getThreadGroup().getName());
        }

    }
}
