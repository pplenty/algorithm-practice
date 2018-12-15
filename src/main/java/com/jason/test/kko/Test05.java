package com.jason.test.kko;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test05 {


    public static void main(String[] args) {

        System.out.println(getJaccardSimilarity("FRANCE", "french"));
        System.out.println();

        System.out.println(getJaccardSimilarity("handshake", "shake hands"));
        System.out.println();

        System.out.println(getJaccardSimilarity("aa1+aa2", "AAAA12"));
        System.out.println();

        System.out.println(getJaccardSimilarity("E=M*C^2", "e=m*c^2"));
        System.out.println();

    }

    public static int getJaccardSimilarity(String str1, String str2) {

        double answer = 1.;

//        System.out.println(getStringSet(str1));
//        System.out.println(getStringSet(str2));
//        System.out.println(getUnion(getStringSet(str1), getStringSet(str2)));
//        System.out.println(getIntersection(getStringSet(str1), getStringSet(str2)));

        int uni = getUnion(getStringSet(str1), getStringSet(str2)).size();
        int inter = getIntersection(getStringSet(str1), getStringSet(str2)).size();

        if (uni == 0) { // 둘다 공집합
            return (int)answer * 65536;
        }
        answer = Math.floor((double)inter / (double)uni * 65536);


        return (int)answer;
    }

    public static List<String> getStringSet(String str) {


        Pattern p = Pattern.compile("^([A-Z])([A-Z])$");

        List<String> stringSet = new ArrayList<>();

        if (str.length() > 1) {
            for (int i = 0; i < str.length() - 1; i++) {

                String element = str.substring(i, i + 2).toUpperCase();
                Matcher m = p.matcher(element);
                if (m.matches()) {
                    stringSet.add(element);
                }
            }
        }

        return stringSet;

    }

    public static List<String> getUnion(List<String> set1, List<String> set2) {
        List<String> unionSet = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        unionSet.addAll(set1);
        temp.addAll(set1);

        for (int i = 0; i < set2.size(); i++) {
            if (temp.contains(set2.get(i))) {
                temp.remove(set2.get(i));
            } else {
                unionSet.add(set2.get(i));
            }
        }
        return unionSet;
    }
    public static List<String> getIntersection(List<String> set1, List<String> set2) {
        List<String> interSet = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.addAll(set1);

        for (int i = 0; i < set2.size(); i++) {
            if (temp.contains(set2.get(i))) {
                interSet.add(set2.get(i));
                temp.remove(set2.get(i));
            }
        }
        return interSet;
    }
}