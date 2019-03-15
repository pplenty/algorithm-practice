package com.jason.java8;

import java.awt.*;
import java.util.concurrent.CompletableFuture;

public class RobotTest {

    public static void main(String[] args) throws AWTException {
        Robot rob = new Robot();
        int startX = 400;
        int startY = 400;

        CompletableFuture f = CompletableFuture.supplyAsync(() -> {
            return 0;
        });
        for (int i = startX; i < startX + 100; i++) {

            int finalI = i;
            new Thread(() -> {

                for (int j = startY; j < startY + 100; j++) {
                    rob.mouseMove(j, finalI);
                }

            }).start();


        }

        System.out.println("end");

        long startTime = System.currentTimeMillis();
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("took " + estimatedTime + " ms");
    }
}
