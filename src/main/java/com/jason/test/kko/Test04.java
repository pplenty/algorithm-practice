package com.jason.test.kko;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Test04 {
	
	static String 첫번째버스시간 = "09:00";
	static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    public static void main(String[] args) throws ParseException {
    	
    	String[] testCase1 = {"08:00", "08:01", "08:02", "08:03"};
    	System.out.println("***** 정답 :" + getBusTime(1, 1, 5, testCase1));
		System.out.println();
        System.out.println();

    	String[] testCase2 = {"09:10", "09:09", "08:00"};
    	System.out.println("***** 정답 : " + getBusTime(2, 10, 2, testCase2));
		System.out.println();
        System.out.println();

    	String[] testCase3 = {"09:00", "09:00", "09:00", "09:00"};
		System.out.println("***** 정답 : " + getBusTime(2, 1, 2, testCase3));
		System.out.println();
        System.out.println();

    	String[] testCase4 = {"00:01", "00:01", "00:01", "00:01", "00:01"};
		System.out.println("***** 정답 : " + getBusTime(1, 1, 5, testCase4));
		System.out.println();
        System.out.println();

    	String[] testCase5 = {"23:59"};
		System.out.println("***** 정답 : " + getBusTime(1, 1, 1, testCase5));
		System.out.println();
        System.out.println();

    	String[] testCase6 = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		System.out.println("***** 정답 : " + getBusTime(10, 60, 45, testCase6));
    	
    }
    
    public static String getBusTime(int 운행횟수, int 운행간격, int 수용인원, String[] timetable) throws ParseException {

    	List<Date> timeArray = timetableToList(timetable);
    	System.out.println(timeArray);
    	
    	String 마지막크루도착시간 = null;
    	boolean 마지막버스만원여부 = false;
    	int j = 0;
		
    	for (int i = 0; i < 운행횟수; i++) {
    		String 버스출발시간 = 날짜가감기(첫번째버스시간, 운행간격 * i);
    		int 현재인원 = 0;
    		System.out.println("버스출발시간 : " + 버스출발시간);
    		for (; j < timeArray.size(); j++) {
    			
    			if (sdf.parse(버스출발시간).compareTo(timeArray.get(j)) < 0 || 현재인원 == 수용인원) {
    				if (현재인원 == 수용인원) {
						마지막버스만원여부 = true;
					}
					break;
				}
				현재인원++;
				마지막크루도착시간 = sdf.format(timeArray.get(j));
				System.out.println(현재인원 + " : " + 마지막크루도착시간);
			}
		}

		System.out.println("마지막크루도착시간 : " + 마지막크루도착시간);

		String 정답;
		if (마지막크루도착시간 == null || 마지막버스만원여부 == false) {
			정답 = 날짜가감기(첫번째버스시간, 운행간격 * (운행횟수 - 1));
		} else {
			정답 = 날짜가감기(마지막크루도착시간, -1);
		}

    	return 정답;
    }
    
    public static String 날짜가감기(String time, int minute) throws ParseException {
    	long t = sdf.parse(time).getTime() + minute * 1000 * 60;
    	return sdf.format(new Date(t));
    }
    
    public static List<Date> timetableToList(String[] timetable) throws ParseException {
    	List<Date> timeArray = new ArrayList<>();
    	for (int i = 0; i < timetable.length; i++) {
    		timeArray.add(sdf.parse(timetable[i]));
		}

		Comparator<Date> c = Date::compareTo;

//    	Comparator<Date> c1 = (o1, o2) -> o1.compareTo(o2);
//    	Comparator<Date> c2 = new Comparator<Date>() {
//			@Override
//			public int compare(Date o1, Date o2) {
//				return o1.compareTo(o2);
//			}
//		};
    	timeArray.sort(c);
    	
    	return timeArray;
    }
}
