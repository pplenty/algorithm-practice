package com.jason.java8;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            stringList.add(String.valueOf(i));
        }

        long startTime = System.currentTimeMillis();
        joinString(stringList);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("took " + estimatedTime + " ms");

//        startTime = System.currentTimeMillis();
//        addString(stringList);
//        estimatedTime = System.currentTimeMillis() - startTime;
//        System.out.println("took " + estimatedTime + " ms");

        startTime = System.currentTimeMillis();
        addStringBuilder(stringList);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("took " + estimatedTime + " ms");

//        startTime = System.currentTimeMillis();
//        addStringReduce(stringList);
//        estimatedTime = System.currentTimeMillis() - startTime;
//        System.out.println("took " + estimatedTime + " ms");

        startTime = System.currentTimeMillis();
        addStringParallelReduce(stringList);
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("took " + estimatedTime + " ms");

    }

    public static String joinString(List<String> list) {
        return String.join("", list);
    }

    public static String addString(List<String> list) {

        String tmp = "";

        for (String string : list) {
            tmp += string;
        }
        return tmp;
    }

    public static String addStringBuilder(List<String> list) {

        StringBuilder tmp = new StringBuilder();

        for (String string : list) {
            tmp.append(string);
        }
        return tmp.toString();
    }

    public static String addStringReduce(List<String> list) {

        return list.stream().reduce("", (s1, s2) -> String.join("", s1, s2));
    }

    public static String addStringParallelReduce(List<String> list) {

        return list.parallelStream().reduce("", (s1, s2) -> s1 + "][" + s2);
    }
}
