package com.jason.test.kko;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test07 {


    public static void main(String[] args) throws ParseException {
        String[] input1 = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        String[] input2 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
        String[] input3 = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};

        solution(input1);
        solution(input2);
        solution(input3);
    }

    public static int solution(String[] lines) throws ParseException {

        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        List<LogTime> logList = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {

            String[] split = lines[i].split(" ");
            String time = split[0] + " " + split[1];
            String resp = split[2].substring(0, split[2].length() - 1);

            Date date = sdf.parse(time);

            long respMs = (long) (Float.valueOf(resp) * 1000);
            long startTime = date.getTime() - respMs + 1;

            logList.add(new LogTime(startTime, date.getTime()));
        }


        for (int i = 0; i < logList.size(); i++) {

            int cnt1 = 1;
            int cnt2 = 1;

            for (int j = 0; j < logList.size(); j++) {

                if (j != i) {
                    // start time
                    long t1 = logList.get(i).startTime - 1000;
                    long t2 = logList.get(i).startTime;

                    if (t1 < logList.get(j).startTime && t2 > logList.get(j).startTime ||
                            t1 < logList.get(j).endTime && t2 > logList.get(j).endTime) {
                        cnt1++;
                    }

                    // end time
                    long t3 = logList.get(i).endTime;
                    long t4 = logList.get(i).endTime + 1000;

                    if (t3 < logList.get(j).startTime && t4 > logList.get(j).startTime ||
                            t3 < logList.get(j).endTime && t4 > logList.get(j).endTime) {
                        cnt2++;
                    }
                }
            }
            // max 값
            cnt1 = cnt1 > cnt2? cnt1: cnt2;
            result = cnt1 > result? cnt1: result;
        }

        System.out.println(logList);
        System.out.println(result);

        return result;

    }

    public static class LogTime {
        LogTime(long s, long e) {
            this.startTime = s;
            this.endTime = e;
        }

        long startTime;
        long endTime;

        @Override
        public String toString() {
            return startTime + " ~ " + endTime;
        }
    }

}