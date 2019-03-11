package com.jason.java8;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    Runnable task = () -> {
        try {
            Thread.sleep(5 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("TASK completed");
    };

    public static void main(String[] args) throws Exception {

        CompletableFutureTest main = new CompletableFutureTest();
        main.completableFuture();


    }

    public void completableFuture() throws Exception {

        CompletableFuture
                .runAsync(task)
                .thenCompose(aVoid -> CompletableFuture.runAsync(task))
                .thenAcceptAsync(aVoid -> System.out.println("all tasks completed!!"))
                .exceptionally(throwable -> {
                    System.out.println("exception occurred!!");
                    return null;
                });
        Thread.sleep(11 * 1000L);
    }
}
